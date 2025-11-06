# Java Programming Basics for FRC Teams

Welcome to the Java Programming Basics repository! This resource is designed to teach high school robotics team members the fundamentals of Java programming, with a focus on concepts relevant to FRC (FIRST Robotics Competition) programming.

## 📚 Course Structure

This repository contains 13 progressive modules plus FRC-specific examples:

### Core Java Modules

1. **Hello World** - First programs, basic output, and input
2. **Data Types** - Understanding Java's type system  
3. **Variables & Expressions** - Working with variables and calculations
4. **Strings** - Text manipulation and string operations
5. **Conditionals** - Making decisions with if/else and switch
6. **Loops** - Repetition with for, while, and do-while loops
7. **Arrays & ArrayList** - Managing collections of data
8. **Methods** - Creating reusable code blocks
9. **Objects & Classes** - Introduction to object-oriented programming
10. **Access & Static** - Understanding access modifiers and static members
11. **Inheritance & Polymorphism** - Advanced OOP concepts
12. **Debugging** - Finding and fixing common errors
13. **2D Arrays** - Working with grids and matrices (includes Tic-Tac-Toe game!)

### FRC-Specific Examples

- **DriveStop** - Robot drive control simulation
- **ClawControl** - Gripper/intake mechanism control
- **TelemetryFormat** - Data formatting and dashboard display

## 🚀 Getting Started

### Prerequisites

1. Install Java Development Kit (JDK) 17 or higher
   - Check installation: `java -version`
   - Download from: https://adoptium.net/ or https://www.oracle.com/java/

2. Install a code editor (optional but recommended):
   - Visual Studio Code with Java Extension Pack
   - IntelliJ IDEA Community Edition
   - Eclipse IDE

### Running the Examples

Each module contains standalone Java files that can be compiled and run independently.

#### Method 1: Using the provided script (Mac/Linux)

```bash
# Run any program using the helper script
./scripts/run.sh modules/01-hello-world HelloWorld

# Examples:
./scripts/run.sh modules/02-data-types DataTypesPlayground
./scripts/run.sh modules/06-loops MenuLoop
./scripts/run.sh modules/13-2d-arrays TicTacToe
```

#### Method 2: Manual compilation

```bash
# Navigate to a module
cd modules/01-hello-world

# Compile
javac HelloWorld.java

# Run
java HelloWorld
```

#### Method 3: Using an IDE

1. Open the entire folder in your IDE
2. Navigate to any `.java` file
3. Click the "Run" button or press the run hotkey

## 📖 Learning Path

### Week 1: Basics
- Start with Module 01 (Hello World)
- Progress through Modules 02-04
- Practice with simple input/output programs

### Week 2: Control Flow
- Complete Modules 05-06 (Conditionals & Loops)
- Try modifying the examples
- Create your own simple programs

### Week 3: Data Structures
- Work through Module 07 (Arrays)
- Understand the difference between arrays and ArrayLists
- Practice with collections of data

### Week 4: Methods & OOP
- Complete Modules 08-09
- Understand how to create and use methods
- Learn the basics of object-oriented programming

### Week 5: Advanced Concepts
- Explore Modules 10-11
- Understand static vs. instance
- Learn about inheritance

### Week 6: Practical Application
- Debug programs in Module 12
- Create the Tic-Tac-Toe game in Module 13
- Explore FRC-specific examples

## 🤖 FRC Relevance

Each concept taught has direct applications in FRC robot programming:

- **Variables & Data Types** → Sensor readings, motor values
- **Conditionals** → Button controls, autonomous decisions
- **Loops** → Continuous robot operation, sensor averaging
- **Arrays** → Managing multiple motors, storing path points
- **Methods** → Reusable robot commands
- **Objects & Classes** → Subsystem organization
- **Inheritance** → Command-based programming structure

## 💡 Tips for Success

1. **Type Everything** - Don't copy/paste. Typing helps memorization.
2. **Experiment** - Modify the examples to see what happens.
3. **Break Things** - Understanding errors helps you learn.
4. **Ask Questions** - No question is too simple.
5. **Practice Daily** - Even 15 minutes helps build skill.

## 🎮 Interactive Examples

Several modules include interactive programs:
- **MenuLoop** (Module 06) - Full menu system
- **TicTacToe** (Module 13) - Complete game
- **BankAccount** (Module 09) - Banking simulation
- **DriveStop** (FRC Examples) - Robot control simulation

## 📝 Common Commands

```bash
# See all modules
ls modules/

# Compile all files in a module
javac modules/05-conditionals/*.java

# Run with the helper script
./scripts/run.sh [module-path] [ClassName]

# Clean compiled files
rm -rf out/
```

## ⚠️ Troubleshooting

### "Cannot find symbol" error
- Check spelling and capitalization (Java is case-sensitive)
- Ensure you've imported required classes

### "Could not find or load main class"
- Check the class name matches the filename
- Ensure you're in the correct directory
- Verify the main method signature: `public static void main(String[] args)`

### Program won't compile
- Check for missing semicolons
- Verify all brackets { } match
- Look for typos in keywords

## 🏆 Challenge Yourself

After completing the modules, try:
1. Combine concepts to create new programs
2. Add features to existing examples
3. Create a simple robot subsystem class
4. Build a match timer program
5. Simulate sensor data processing

## 📚 Additional Resources

- [Official Java Documentation](https://docs.oracle.com/en/java/)
- [WPILib Documentation](https://docs.wpilib.org/) (FRC-specific)
- [Chief Delphi Forums](https://www.chiefdelphi.com/)
- [FRC Discord](https://discord.gg/frc)

## 🤝 Contributing

Found an error or have a suggestion? Feel free to:
1. Talk to your programming mentor
2. Create an issue in the repository
3. Submit improvements

## 📜 License

This educational resource is provided for FRC teams to learn Java programming.

---

**Remember:** Programming is a skill that improves with practice. Don't get discouraged if concepts don't click immediately. Every professional programmer was once a beginner. Keep coding, stay curious, and have fun!

Good luck with your season! 🤖

*Created for FRC Team Mentorship*
