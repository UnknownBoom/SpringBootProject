let options = document.querySelectorAll("select");
console.log(options);

let input = document.querySelectorAll("input#rolesData");
console.log(input);

let roles_event_listener = function(e) {

    input.name = $("#rolesSelect option:selected").text().toLowerCase();
    console.log(input.name);


};

for(let i = 0; i < options.length; i++){
    options[i].addEventListener('change', roles_event_listener)
}



