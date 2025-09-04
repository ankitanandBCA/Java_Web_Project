function enroll()
{
    alert("Plz Login First...");

}

function signup(event){
    event.preventDefault();
    window.location.href="UserSignUp.html"
}

function signin(event){
     event.preventDefault();
    window.location.href="UserLogin.html";
}

/* show and hide password */
  const passwordField = document.getElementById("password");
  const togglePassword = document.getElementById("togglePassword");

  togglePassword.addEventListener("click", () => {
    if (passwordField.type === "password") {
      passwordField.type = "text";
      togglePassword.textContent = "Hide";
    } else {
      passwordField.type = "password";
      togglePassword.textContent = "Show";
    }
  });

  /*  hosting*/
