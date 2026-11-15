// chay trong <head> de dat theme truoc khi trang hien ra (khong bi nhay mau)
// uu tien: lua chon da luu > cai dat cua may
(function () {
  let daLuu = null;
  try {
    daLuu = localStorage.getItem("theme");
  } catch (e) {
    // mot so trinh duyet chan localStorage, bo qua
  }
  const mayToi = window.matchMedia("(prefers-color-scheme: dark)").matches;
  const theme = daLuu || (mayToi ? "dark" : "light");
  document.documentElement.setAttribute("data-theme", theme);
  document.documentElement.classList.add("js");
})();
