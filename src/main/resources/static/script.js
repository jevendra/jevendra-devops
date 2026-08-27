const foodsEl=document.getElementById("foods");let cart=0;
async function loadFoods(){
 try{
  const res=await fetch("/api/foods"); const foods=await res.json();
  foodsEl.innerHTML=foods.length?foods.map(f=>`
   <article class="card"><img src="${f.imageUrl||'https://images.unsplash.com/photo-1504674900247-0877df9cc836'}" alt="${f.name}">
   <div class="card-body"><h3>${f.name}</h3><p>${f.description||''}</p><p class="price">₹${Number(f.price).toFixed(2)}</p>
   <button onclick="addCart()">Add to Cart</button></div></article>`).join(""):"<p>No menu items yet. Add food through POST /api/foods.</p>";
 }catch(e){foodsEl.innerHTML="<p>Backend connection failed. Check the server.</p>";}
}
function addCart(){cart++;document.getElementById("cart").textContent=`Cart: ${cart}`;loadFoods();}
loadFoods();