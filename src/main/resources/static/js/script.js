
// ===========================
// CONTACT FORM INTEGRATION
// ===========================

const form = document.getElementById("contactForm");

if (form) {
    form.addEventListener("submit", async function (e) {
        e.preventDefault();

        const name = document.getElementById("name").value.trim();
        const email = document.getElementById("email").value.trim();
        const message = document.getElementById("message").value.trim();

        const formMessage = document.getElementById("formMessage");
        const submitButton = document.getElementById("submitButton");

        // Basic client-side validation
        if (!name || !email || !message) {
            formMessage.style.color = "red";
            formMessage.textContent = "Please fill in all fields.";
            return;
        }

        // Email validation
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!emailPattern.test(email)) {
            formMessage.style.color = "red";
            formMessage.textContent = "Please enter a valid email address.";
            return;
        }

        // Show loading state
        formMessage.style.color = "#d4af37";
        formMessage.textContent = "Sending your message...";

        submitButton.disabled = true;
        submitButton.innerHTML =
            '<i class="bi bi-hourglass-split me-2"></i> Sending...';

        try {
            // Send message to Spring Boot backend
            const response = await fetch("/api/contact", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    name: name,
                    email: email,
                    message: message
                })
            });

            const result = await response.json();

            if (!response.ok) {
                throw new Error(
                    result.message || "Unable to send your message."
                );
            }

            // Success
            formMessage.style.color = "green";
            formMessage.textContent =
                result.message || "Your message has been sent successfully!";

            form.reset();

        } catch (error) {
            // Error
            formMessage.style.color = "red";
            formMessage.textContent =
                error.message || "Something went wrong. Please try again.";
        } finally {
            // Restore button
            submitButton.disabled = false;
            submitButton.innerHTML =
                '<i class="bi bi-send-fill me-2"></i> Send Message';
        }
    });
}
