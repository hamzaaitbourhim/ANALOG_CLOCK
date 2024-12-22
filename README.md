# Horloge Mini Project

## Description
This project, titled **"Horloge"**, is a simple Java-based graphical application designed to display a functioning clock. The project demonstrates the use of Java Swing for GUI development, basic threading for real-time updates, and fundamental programming concepts such as object-oriented design and 2D graphics.

This project was created as part of a practical exercise (TP) to practice and apply Java programming skills.

---

## Features
- **Analog Clock Display:** A visual representation of an analog clock with accurate hour, minute, and second hands.
- **Dynamic Updates:** Real-time updates every second using threading.
- **Custom Design:** The clock is displayed within a custom JFrame window and features a red background, a black clock face, and white tick marks for hours.
- **Modular Design:** Code is split into logical components, including a `FenetreHorloge` class for managing the JFrame and a `Horloge` class for rendering the clock.

---

## Getting Started

### Prerequisites
- **Java Development Kit (JDK)**: Version 8 or higher
- **IDE or Text Editor**: IntelliJ IDEA, Eclipse, VS Code, or any preferred text editor

### Installation
1. **Clone or Download**
   - Copy the source code provided and save it into a file named `FenetreHorloge.java`.

2. **Compile**
   - Open a terminal or command prompt.
   - Navigate to the directory containing `FenetreHorloge.java`.
   - Compile the program using:
     ```bash
     javac FenetreHorloge.java
     ```

3. **Run**
   - Execute the program using:
     ```bash
     java FenetreHorloge
     ```

4. **Output**
   - A window displaying the analog clock will appear and update in real time.

---

## How It Works
- **Time Retrieval:** The `Date` class is used to fetch the current time at the start of the program.
- **Clock Logic:** Time values (hours, minutes, seconds) are incremented in a loop and redrawn every second.
- **Graphics Rendering:** The `paintComponent` method of the `Horloge` class uses the `Graphics` object to draw the clock's face and hands.
- **Threading:** The infinite loop in the `FenetreHorloge` class ensures the clock updates dynamically, with a delay of one second between updates using `Thread.sleep`.

---

## Project Structure
```
FenetreHorloge.java  // Main file containing classes FenetreHorloge and Horloge
```
- `FenetreHorloge`: 
  - Creates the main application window.
  - Manages the clock's threading logic and time calculation.
- `Horloge`:
  - Handles rendering of the clock's graphics.
  - Draws the clock face, tick marks, and hands based on the current time.

---

## Challenges and Learning Outcomes
### Challenges
- Ensuring the clock updates in real-time without freezing the UI.
- Correctly positioning elements (numbers, tick marks, hands) in a circular layout.

### Learning Outcomes
- Understanding Java Swing for GUI applications.
- Using threading (`Thread.sleep`) for time-sensitive tasks.
- Applying trigonometry to calculate positions for clock elements.
- Structuring code for modular and reusable components.

---

## Future Improvements
- **Multithreading Enhancement:** Use a separate thread for updating the clock to avoid potential UI freezing.
- **Digital Clock Addition:** Add a digital display below the analog clock.
- **Customizable Themes:** Allow users to change colors and styles of the clock.
- **Resizable Window:** Enable dynamic resizing of the window while maintaining clock proportions.

---

## Acknowledgements
- This project was developed as part of a school exercise (TP).
- Special thanks to the instructor for providing guidance and support.

---

## Author
**Name:** Hamza Ait Bourhim


