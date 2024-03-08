document.addEventListener("DOMContentLoaded", function () {

  var loginForm = document.getElementById("loginForm");

  loginForm.addEventListener("submit", function (event) {

    event.preventDefault();

    showLoadingAlert();

    setTimeout(function () {

      loginForm.submit();
    }, 1500);
  });
});

function showLoadingAlert() {
  Swal.fire({
    title: "Ładowanie, prosimy czekać.",
    width: 600,
    padding: "3em",
    icon: "info",
    background: '#fbf7f4',
    showConfirmButton: false,
    backdrop: `
      rgba(0, 0, 140, 0.3)
      url("/img/stars.gif")
      repeat
    `
  });
}
