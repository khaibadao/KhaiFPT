// chay khi di chuot vao 1 anh nho
function upDate(previewPic) {
  console.log("upDate da chay");
  console.log("alt: " + previewPic.alt);
  console.log("src: " + previewPic.src);

  // doi chu trong khung lon thanh alt cua anh
  document.getElementById("image").innerHTML = previewPic.alt;

  // doi hinh nen thanh anh vua di chuot vao
  document.querySelector("#image").style.backgroundImage = "url('" + previewPic.src + "')";
}

// chay khi chuot roi khoi anh
function unDo() {
  console.log("unDo da chay");

  let khung = document.getElementById("image");
  khung.style.backgroundImage = "url('')";
  khung.innerHTML = "Di chuột qua một hình ảnh bên dưới để hiển thị ở đây.";
}
