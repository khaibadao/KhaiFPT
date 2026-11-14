'use strict';

/*
 * Dua tren script.js cua template vCard (codewithsadee, MIT).
 * Khai da sua:
 *  - bo phan testimonials / modal / form (da bo khoi trang)
 *  - menu tab so theo data-target thay vi so chu (de doi ten tab sang tieng Viet)
 *  - them aria-current, aria-expanded, aria-pressed va dia chi #hash cho tung tab
 *  - them dong thong bao so muc dang hien khi loc (aria-live)
 */


// ham bat / tat class active
const elementToggleFunc = function (elem) { elem.classList.toggle("active"); };


// ===== sidebar tren dien thoai =====
const sidebar = document.querySelector("[data-sidebar]");
const sidebarBtn = document.querySelector("[data-sidebar-btn]");
const sidebarBtnText = sidebarBtn.querySelector("span");

sidebarBtn.addEventListener("click", function () {
  elementToggleFunc(sidebar);
  const mo = sidebar.classList.contains("active");
  sidebarBtn.setAttribute("aria-expanded", mo ? "true" : "false");
  sidebarBtnText.textContent = mo ? "Ẩn liên hệ" : "Xem liên hệ";
});


// ===== loc du an =====
const select = document.querySelector("[data-select]");
const selectItems = document.querySelectorAll("[data-select-item]");
const selectValue = document.querySelector("[data-select-value]");
const filterBtn = document.querySelectorAll("[data-filter-btn]");
const filterItems = document.querySelectorAll("[data-filter-item]");
const filterStatus = document.querySelector("[data-filter-status]");

select.addEventListener("click", function () {
  elementToggleFunc(this);
  this.setAttribute("aria-expanded", this.classList.contains("active") ? "true" : "false");
});

const filterFunc = function (value) {
  let dem = 0;

  for (let i = 0; i < filterItems.length; i++) {
    const hien = value === "all" || value === filterItems[i].dataset.category;
    filterItems[i].classList.toggle("active", hien);
    if (hien) dem++;
  }

  filterStatus.textContent = "Đang hiện " + dem + " mục";

  // dong bo nut loc tren may tinh
  filterBtn.forEach(function (btn) {
    const dangChon = btn.dataset.value === value;
    btn.classList.toggle("active", dangChon);
    btn.setAttribute("aria-pressed", dangChon ? "true" : "false");
  });
};

// danh sach chon tren dien thoai
for (let i = 0; i < selectItems.length; i++) {
  selectItems[i].addEventListener("click", function () {
    selectValue.innerText = this.innerText;
    elementToggleFunc(select);
    select.setAttribute("aria-expanded", "false");
    filterFunc(this.dataset.value);
    select.focus();
  });
}

// nut loc tren man hinh lon
for (let i = 0; i < filterBtn.length; i++) {
  filterBtn[i].addEventListener("click", function () {
    selectValue.innerText = this.innerText;
    filterFunc(this.dataset.value);
  });
}


// ===== chuyen tab =====
const navigationLinks = document.querySelectorAll("[data-nav-link]");
const pages = document.querySelectorAll("[data-page]");

const moTab = function (ten, cuonLen) {
  let timThay = false;

  for (let i = 0; i < pages.length; i++) {
    const dung = pages[i].dataset.page === ten;
    pages[i].classList.toggle("active", dung);
    if (dung) timThay = true;
  }

  if (!timThay) return;

  for (let i = 0; i < navigationLinks.length; i++) {
    const dung = navigationLinks[i].dataset.target === ten;
    navigationLinks[i].classList.toggle("active", dung);
    if (dung) {
      navigationLinks[i].setAttribute("aria-current", "page");
    } else {
      navigationLinks[i].removeAttribute("aria-current");
    }
  }

  if (cuonLen) window.scrollTo(0, 0);
};

for (let i = 0; i < navigationLinks.length; i++) {
  navigationLinks[i].addEventListener("click", function () {
    const ten = this.dataset.target;
    moTab(ten, true);
    // luu tab vao dia chi de nut Back va chia se link dung tab
    history.pushState(null, "", "#" + ten);
  });
}

// mo dung tab khi vao bang link co #hash hoac bam Back
const theoHash = function () {
  const ten = location.hash.replace("#", "") || "about";
  moTab(ten, false);
};

window.addEventListener("popstate", theoHash);
theoHash();
