// Welcome Message

let username = prompt("Enter your name:");

if(username != null && username != ""){

document.getElementById("welcomeMessage").innerHTML =
"Welcome to the Online Bookstore, " + username + "!";

}

// Form Validation

function validateForm(){

let name = document.getElementById("name").value;

let email = document.getElementById("email").value;

let phone = document.getElementById("phone").value;

if(name=="" || email=="" || phone==""){

alert("Please complete all required fields.");

return false;

}

alert("Registration Successful!");

return true;

}

// Interactive Feature 1

function showBooks(){

document.getElementById("bookInfo").innerHTML =
"Our best-selling books are Java Programming, HTML & CSS, JavaScript Essentials and Database Systems.";

}

// Interactive Feature 2

function changeTheme(){

document.body.style.backgroundColor="#dff6ff";

document.body.style.color="darkblue";

}

// Interactive Feature 3

function changeBookImage(){

let image=document.getElementById("galleryImage");

if(image.src.includes("books1.jpg")){

image.src="books2.jpg";

}

else{

image.src="books1.jpg";

}

}