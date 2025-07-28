function addtocart(name, price, image) {



    


    const item = { name, price, image, quantity: 1 };
    let cart = JSON.parse(localStorage.getItem("cart")) || [];

    const existing = cart.find(i => i.name === name);
    if (existing) {
      existing.quantity += 1;
    } else {
      cart.push(item);
    }
localStorage.setItem("cart", JSON.stringify(cart));
    alert(`${name} added to cart`);
  }

  function goToCart() {
    window.location.href = "AddToCart.html";
  }