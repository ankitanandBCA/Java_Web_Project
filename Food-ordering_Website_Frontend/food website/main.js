var swiper = new Swiper(".mySwiper", {
  loop: true,
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
});




function click()
{
  window.location.href='cart.html'
}






let productList = [];

const productslists=document.querySelector('.products-container')


const showcart = () => {
  productList.forEach((item) => {
    const ordercart = document.createElement("div");
    ordercart.classList.add("order-cart");

    ordercart.innerHTML = `

 <div class="cart-img">
    <img src="${item.image}" alt="">
 </div>
  <h4>${item.name}</h4>
  <h4 class="price">${item.price}</h4>
  <a href="" class="btn">Add to cart</a>

`;





   












productslists.appendChild(ordercart)






  });
};

const listingProduct = () => {
  fetch("product.json")
    .then((Response) => Response.json())
    .then((data) => {
      productList = data;
      showcart();
    });
};

listingProduct();
















