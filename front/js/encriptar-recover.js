// Función para encriptar un texto usando AES
export function encriptarTexto(texto, clave) {
  const iv = forge.random.getBytesSync(16); // Generar un IV aleatorio
  const cipher = forge.cipher.createCipher('AES-CBC', clave);
  cipher.start({ iv });
  cipher.update(forge.util.createBuffer(texto, 'utf8'));
  cipher.finish();
  return {
      iv: forge.util.encode64(iv),
      textoEncriptado: forge.util.encode64(cipher.output.getBytes())
  };
}

// Función para desencriptar un texto encriptado usando AES
export function desencriptarTexto(textoEncriptado, clave) {
  const iv = forge.util.decode64(textoEncriptado.iv);
  const textoBytes = forge.util.decode64(textoEncriptado.textoEncriptado);
  const decipher = forge.cipher.createDecipher('AES-CBC', clave);
  decipher.start({ iv });
  decipher.update(forge.util.createBuffer(textoBytes));
  decipher.finish();
  return decipher.output.toString('utf8');
}

export let claveSecreta = "UnaClaveSecretaMuySegura";