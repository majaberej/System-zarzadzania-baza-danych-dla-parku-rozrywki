document.addEventListener("DOMContentLoaded", function () {

  var loginForm = document.getElementById("loginForm");

  loginForm.addEventListener("submit", function (event) {

    event.preventDefault();

    successfullyLogout();

    setTimeout(function () {

      loginForm.submit();
    }, 800);
  });
});

function successfullyLogout(){
 Swal.fire({
    title: "Wylogowano pomyślnie.",
    width: 600,
    padding: "3em",
    icon: "info",
    background: '#fbf7f4',
    showConfirmButton: false,
  });
}