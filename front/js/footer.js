const footer = `
<style>
footer {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;
  background-color: #222;
  color: white;
  height: 11vh;
  width: 100vw;
}

.footer-container h3 {
  font-size: 1.6rem;
  text-align: start;
  line-height: 2rem;
}

.footer-container {
  margin-top: 2px;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 95%;
}

.footer-info,
.footer-social,
.footer-contact {
  width: 300px;
}

.footer-social {
  display: flex;
  flex-flow: column wrap;
  align-items: center;
}

.footer-social ul {
  list-style: none;
  padding: 0px; 
}

.footer-social ul li img {
  transition: all .2s ease-in-out;
  width: 35px;
  height: 35px;
}

.footer-social ul li img:hover {
  transform: scale(1.1);
  opacity: .6;
}

.footer-social ul li {
  display: inline-block;
}
</style>

<footer>
        <div class="footer-container">
            <div class="footer-info">
                <h3>LinguoLearn</h3>
                <p>Una plataforma educativa para aprender idiomas de forma interactiva.</p>
            </div>
            
            <div class="footer-social">
                <h3>Síguenos</h3>
                <ul>
                    <li><a href="#"><img src="./img/facebook.webp" alt=""></a></li>
                    <li><a href="#"><img src="./img/ig.webp" alt=""></a></li>
                    <li><a href="#"><img src="./img/twitter.webp" alt=""></a></li>
                </ul>
            </div>

            <div class="footer-contact">
                <h3>Contacto</h3>
                <p>Correo electrónico: info@linguolearn.com</p>
                <p>Teléfono: +1234567890</p>
            </div>
        </div>
    </footer>
`

export { footer }