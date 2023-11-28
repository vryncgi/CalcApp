### Documentation for `CalculatorApp.java`

---

#### Class: `CalculatorApp`
- **Description**: This class is the core of the Bonus Calculator application. It extends the JavaFX `Application` class, making it a graphical application. JavaFX is chosen for its rich set of UI components and ease of creating responsive and interactive applications.
- **Variables**:
  - `StringBuilder currentInput`: Utilized for dynamically building and updating the numeric input. `StringBuilder` is preferred over `String` for its efficiency in append and delete operations, which are frequent in a calculator.
  - `String lastOperation`: Stores the operation last performed, like addition or subtraction. This helps in managing consecutive calculations and the calculator's state.
  - `double lastNumber`: Caches the last entered number or the result of the previous calculation. It's essential for continuous calculations without the need for re-entering the previous result.
  - `double result`: This holds the result of the current calculation. A separate variable for the result allows for clear separation between the input state and the output.
  - `boolean canClearDisplay`: A flag to control the display's clear behavior, ensuring that the display is only cleared when appropriate.
  - `Label displayLabel`: A JavaFX Label component used to display the input and results. Labels are chosen for their simplicity and effectiveness in displaying text.

#### Methods in `CalculatorApp`
1. **`start(Stage primaryStage)`**
   - **Description**: Sets up the primary stage (window) for the application, including the layout and UI components. This method is the entry point for any JavaFX application, initiating the UI rendering.
   - **Parameters**: `Stage primaryStage` – the primary window of the application.
   - **Return Type**: `void`

2. **`setUpDisplay(GridPane grid)`**
   - **Description**: Configures the display area where the results and inputs are shown. Using a `GridPane` allows for easy placement and alignment of the display within the UI.
   - **Parameters**: `GridPane grid` – the layout manager where the display is placed.
   - **Return Type**: `void`

3. **`setUpButtons(GridPane grid)`**
   - **Description**: Initializes the calculator's buttons and adds them to the UI. The method strategically places buttons in the `GridPane` for optimal user interaction and aesthetic appeal.
   - **Parameters**: `GridPane grid` – the layout manager where buttons are arranged.
   - **Return Type**: `void`

4. **`handleButtonClick(String buttonText)`**
   - **Description**: Manages the actions taken when a user presses a button. This method is crucial for the calculator's interactivity, handling both numerical input and operational commands.
   - **Parameters**: `String buttonText` – the label of the button clicked.
   - **Return Type**: `void`

#### Additional Components
- **UI Layout**: Discusses the arrangement and styling of UI components. The choice of layout (e.g., `GridPane`) is based on its flexibility and ease of organizing components in a grid-like fashion.
- **Event Handling**: Details how user interactions, like button clicks, are captured and processed. Event-driven programming is a key aspect of UI applications, and this section will explain how events are mapped to calculator functions.
- **Error Handling**: Explains how the application deals with exceptions and user errors, like invalid inputs or overflow conditions.

#### Code Examples
- **Adding a Button**: Demonstrates how to add a button to the UI, including setting its label, size, and event handler. This example will illustrate the use of lambda expressions for handling click events.
- **Performing a Calculation**: Showcases how a basic arithmetic operation is carried out, emphasizing the separation of UI logic from the calculation logic.

---

This documentation provides a detailed overview of the `CalculatorApp` class, highlighting the rationale behind the design and implementation choices. Each section and method explanation offers insights into why certain programming constructs and patterns are used, making it valuable for both developers and users who wish to understand the application's inner workings.