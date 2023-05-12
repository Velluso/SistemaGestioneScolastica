const inputText = document.querySelectorAll(".input_text");

inputText.forEach((element) => {
    element.addEventListener("focus", () => {
        const icon = element.previousElementSibling;
        icon.classList.add("glowIcon");
    });

    element.addEventListener("focusout", () => {
        const icon = element.previousElementSibling;
        icon.classList.remove("glowIcon");
    });
});

