function generateTicket(){

    let name = document.getElementById("name").value;
    let category = document.getElementById("category").value;
    let message = "";

    if(name === "" || category === ""){
        alert("Please fill in all details");
        return;
    }

    if(category === "child"){
        message = "Congratulations! You get FREE POPCORN 🍿";
    }
    else if(category === "adult"){
        message = "Reminder: Please supervise your children during the movie.";
    }

    document.getElementById("ticket").innerHTML =
        "<h3>Movie Ticket</h3>" +
        "<p><strong>Name:</strong> " + name + "</p>" +
        "<p><strong>Category:</strong> " + category + "</p>" +
        "<p><strong>Message:</strong> " + message + "</p>";
}