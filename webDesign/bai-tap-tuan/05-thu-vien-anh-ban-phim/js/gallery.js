// chay khi di chuot vao hoac tab toi 1 anh nho
function upDate(previewPic) {
  console.log("upDate da chay");
  console.log("alt: " + previewPic.alt);
  console.log("src: " + previewPic.src);

  // doi chu trong khung lon thanh alt cua anh
  document.getElementById("image").innerHTML = previewPic.alt;

  // doi hinh nen thanh anh dang chon
  document.querySelector("#image").style.backgroundImage = "url('" + previewPic.src + "')";
}

// chay khi chuot roi khoi anh hoac anh mat focus
function unDo() {
  console.log("unDo da chay");

  let khung = document.getElementById("image");
  khung.style.backgroundImage = "url('')";
  khung.innerHTML = "Di chuột qua một hình ảnh bên dưới để hiển thị ở đây.";
}

// chay khi trang load xong (onload tren body)
// them tabindex cho tung anh de bam Tab duoc
function addTabFocus() {
  console.log("trang da load, bat dau them tabindex");

  let anh = document.querySelectorAll(".preview");
  for (let i = 0; i < anh.length; i++) {
    anh[i].setAttribute("tabindex", "0");
    console.log("da them tabindex cho anh " + (i + 1) + ": " + anh[i].alt);
  }
}
