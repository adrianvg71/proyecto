import { navbar } from "./navbar.js";

window.onload = function() {
  document.body.insertAdjacentHTML('afterbegin', navbar);
  const scriptContent = document.querySelector('nav script').textContent;
  const scriptElement = document.createElement('script');
  scriptElement.type = "module";
  scriptElement.textContent = scriptContent;
  document.body.appendChild(scriptElement);
};