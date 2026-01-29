const clickSound = new Audio("../assets/mouseclick1.ogg");
clickSound.volume = 0.4;

document.addEventListener("click", (e) => {
    if (e.target.closest("button, a, .clickable")) {
        clickSound.currentTime = 0;
        clickSound.play();
    }
});
