// ===== 1. nut doi che do sang / toi =====
const themeBtn = document.querySelector(".theme-btn");
const themeText = document.querySelector(".theme-text");

function capNhatNutTheme() {
  const toi = document.documentElement.getAttribute("data-theme") === "dark";
  themeBtn.setAttribute("aria-pressed", toi ? "true" : "false");
  themeText.textContent = toi ? "Chế độ sáng" : "Chế độ tối";
}

themeBtn.addEventListener("click", function () {
  const toi = document.documentElement.getAttribute("data-theme") === "dark";
  const moi = toi ? "light" : "dark";
  document.documentElement.setAttribute("data-theme", moi);
  try {
    localStorage.setItem("theme", moi);
  } catch (e) {
    // khong luu duoc thi thoi
  }
  capNhatNutTheme();
});

capNhatNutTheme();

// ===== 2. menu tren dien thoai =====
const menuBtn = document.querySelector(".menu-btn");
const nav = document.getElementById("site-nav");

menuBtn.addEventListener("click", function () {
  const mo = menuBtn.getAttribute("aria-expanded") === "true";
  menuBtn.setAttribute("aria-expanded", mo ? "false" : "true");
  nav.classList.toggle("is-open", !mo);
});

// bam vao 1 muc thi dong menu lai
nav.querySelectorAll("a").forEach(function (link) {
  link.addEventListener("click", function () {
    menuBtn.setAttribute("aria-expanded", "false");
    nav.classList.remove("is-open");
  });
});

// bam Esc cung dong menu
document.addEventListener("keydown", function (e) {
  if (e.key === "Escape" && nav.classList.contains("is-open")) {
    menuBtn.setAttribute("aria-expanded", "false");
    nav.classList.remove("is-open");
    menuBtn.focus();
  }
});

// ===== 3. loc du an =====
const filters = document.querySelectorAll(".filter");
const projects = document.querySelectorAll(".project");
const status = document.querySelector(".filter-status");

filters.forEach(function (btn) {
  btn.addEventListener("click", function () {
    const loai = btn.dataset.filter;
    let dem = 0;

    filters.forEach(function (b) {
      b.classList.toggle("is-active", b === btn);
      b.setAttribute("aria-pressed", b === btn ? "true" : "false");
    });

    projects.forEach(function (p) {
      const hien = loai === "all" || p.dataset.type === loai;
      p.hidden = !hien;
      if (hien) {
        dem++;
      }
    });

    status.textContent = "Đang hiện " + dem + " dự án";
  });
});

// ===== 4. hien dan khi cuon toi =====
const canHien = document.querySelectorAll(".reveal");
const giamChuyenDong = window.matchMedia("(prefers-reduced-motion: reduce)").matches;

if (giamChuyenDong || !("IntersectionObserver" in window)) {
  canHien.forEach(function (el) {
    el.classList.add("is-visible");
  });
} else {
  const quanSat = new IntersectionObserver(function (entries) {
    entries.forEach(function (entry) {
      if (entry.isIntersecting) {
        entry.target.classList.add("is-visible");
        quanSat.unobserve(entry.target);
      }
    });
  }, { threshold: 0.15 });

  canHien.forEach(function (el) {
    quanSat.observe(el);
  });
}

// nam o footer tu cap nhat
document.getElementById("year").textContent = new Date().getFullYear();
