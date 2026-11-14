// khi modal sap mo: lay anh tu nut vua bam roi dua vao modal
const viewer = document.getElementById("viewer");

viewer.addEventListener("show.bs.modal", function (e) {
  const nut = e.relatedTarget;
  const anhNho = nut.querySelector("img");

  document.getElementById("viewerTitle").textContent = nut.dataset.title;
  const anhLon = document.getElementById("viewerImg");
  anhLon.src = nut.dataset.src;
  anhLon.alt = anhNho.alt;
});
