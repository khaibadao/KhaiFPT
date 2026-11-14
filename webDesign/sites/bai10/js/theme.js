// doi giao dien sang/toi theo cai dat cua may
// bootstrap 5.3 dung thuoc tinh data-bs-theme tren the html
const cheDoToi = window.matchMedia("(prefers-color-scheme: dark)");

function datTheme() {
  document.documentElement.setAttribute("data-bs-theme", cheDoToi.matches ? "dark" : "light");
}

datTheme();
cheDoToi.addEventListener("change", datTheme);
