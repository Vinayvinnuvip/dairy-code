const body = document.querySelector("body"),
	sidebar = body.querySelector(".sidebar"),
	toggle = body.querySelector(".toggle"),
	searchBtn = body.querySelector(".search-box"),
	modeSwitch = body.querySelector(".toggle-switch"),
	modeText = body.querySelector(".mode-text");

let getMode = localStorage.getItem("mode")

if (getMode === "dark") {
	body.classList.toggle("dark");
}
let getToggle = localStorage.getItem("toggle")
if (getToggle === "close") {
	sidebar.classList.toggle("close")
}
toggle.addEventListener("click", () => {
	sidebar.classList.toggle("close");
	if (sidebar.classList.contains("close")) {
		localStorage.setItem("toggle", "close")
	} else {
		localStorage.setItem("toggle", "open")
	}

});
searchBtn.addEventListener("click", () => {
	sidebar.classList.remove("close");

});


modeSwitch.addEventListener("click", () => {
	body.classList.toggle("dark");

	if (body.classList.contains("dark")) {
		modeText.innerText = "Light Mode"
		localStorage.setItem("mode", "dark")
		
	}
	else {
		modeText.innerText = "Dark Mode"
		localStorage.setItem("mode", "light")

	}


});