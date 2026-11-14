// Bulma chi co CSS, khong kem JavaScript -> cac phan tuong tac tu viet o day.

// ===== 1. nut burger tren dien thoai =====
const burger = document.querySelector(".navbar-burger");
const menu = document.getElementById(burger.dataset.target);

burger.addEventListener("click", function () {
  const mo = burger.classList.toggle("is-active");
  menu.classList.toggle("is-active", mo);
  burger.setAttribute("aria-expanded", mo ? "true" : "false");
});

// chon 1 muc thi dong menu
menu.querySelectorAll("a").forEach(function (a) {
  a.addEventListener("click", function () {
    burger.classList.remove("is-active");
    menu.classList.remove("is-active");
    burger.setAttribute("aria-expanded", "false");
  });
});


// ===== 2. loc anh theo chu de =====
const tabs = document.querySelectorAll(".filter-tabs button");
const cots = document.querySelectorAll(".photo-grid .column");
const trangThai = document.querySelector(".filter-status");

tabs.forEach(function (tab) {
  tab.addEventListener("click", function () {
    const loai = tab.dataset.filter;
    let dem = 0;

    tabs.forEach(function (t) {
      const chon = t === tab;
      t.parentElement.classList.toggle("is-active", chon);
      t.setAttribute("aria-pressed", chon ? "true" : "false");
    });

    cots.forEach(function (c) {
      const hien = loai === "all" || c.dataset.cat === loai;
      c.hidden = !hien;
      if (hien) dem++;
    });

    trangThai.textContent = "Đang hiện " + dem + " ảnh";
  });
});


// ===== 3. khung xem anh: mo, dong, chuyen anh, giu focus ben trong =====
const viewer = document.getElementById("viewer");
const viewerImg = document.getElementById("viewerImg");
const viewerTitle = document.getElementById("viewerTitle");
const viewerCount = document.getElementById("viewerCount");
const nutAnh = Array.from(document.querySelectorAll(".photo-btn"));
let dangXem = 0;
let nutVuaBam = null;

// chi duyet nhung anh dang hien (sau khi loc)
function anhDangHien() {
  return nutAnh.filter(function (b) {
    return !b.closest(".column").hidden;
  });
}

function hienAnh(viTri) {
  const ds = anhDangHien();
  dangXem = (viTri + ds.length) % ds.length;
  const nut = ds[dangXem];
  const anhNho = nut.querySelector("img");

  viewerImg.src = nut.dataset.full;
  viewerImg.alt = anhNho.alt;
  viewerTitle.textContent = nut.closest(".card").querySelector(".title").textContent;
  viewerCount.textContent = "(" + (dangXem + 1) + "/" + ds.length + ")";
}

function moViewer(nut) {
  nutVuaBam = nut;
  hienAnh(anhDangHien().indexOf(nut));
  viewer.classList.add("is-active");
  document.documentElement.classList.add("is-clipped");
  viewer.querySelector("[data-next]").focus();
}

function dongViewer() {
  viewer.classList.remove("is-active");
  document.documentElement.classList.remove("is-clipped");
  if (nutVuaBam) nutVuaBam.focus(); // tra focus ve dung anh vua mo
}

nutAnh.forEach(function (nut) {
  nut.addEventListener("click", function () {
    moViewer(nut);
  });
});

viewer.querySelectorAll("[data-close]").forEach(function (el) {
  el.addEventListener("click", dongViewer);
});
viewer.querySelector("[data-prev]").addEventListener("click", function () { hienAnh(dangXem - 1); });
viewer.querySelector("[data-next]").addEventListener("click", function () { hienAnh(dangXem + 1); });

document.addEventListener("keydown", function (e) {
  if (!viewer.classList.contains("is-active")) return;

  if (e.key === "Escape") dongViewer();
  if (e.key === "ArrowRight") hienAnh(dangXem + 1);
  if (e.key === "ArrowLeft") hienAnh(dangXem - 1);

  // giu Tab quanh quan trong khung (focus trap)
  if (e.key === "Tab") {
    const nut = Array.from(viewer.querySelectorAll("button"));
    const dau = nut[0];
    const cuoi = nut[nut.length - 1];
    if (e.shiftKey && document.activeElement === dau) {
      e.preventDefault();
      cuoi.focus();
    } else if (!e.shiftKey && document.activeElement === cuoi) {
      e.preventDefault();
      dau.focus();
    }
  }
});
