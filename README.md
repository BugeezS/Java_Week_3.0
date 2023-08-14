# Java Week 3: Clean Project and Object-Oriented Programming (OOP)

## The Mission

Welcome to Java Week 3! In this challenge, you will dive into the world of Object-Oriented Programming (OOP), unit testing, and build tools within the context of Java programming. Your task is to build a data analysis command-line tool that processes a CSV file containing information about how Covid-19 has impacted trade as of July 2021. The tool should handle various commands and parameters, providing insights into trade statistics. Alongside the implementation, you'll write tests to ensure robustness and utilize Maven as a build tool for project management.

### Commands

Your program will recognize the following mandatory commands:

- `help`: List available commands with brief descriptions.
- `help <command>`: Provide detailed explanation and required parameters for a specific command.
- `monthly_total`: Calculate sum of export and import for a given month and year.
- `monthly_average`: Calculate average of export and import for a given month and year.
- `yearly_total`: Display monthly and yearly totals for both import and export.
- `yearly_average`: Display monthly and yearly averages for both import and export.
- `overview`: Provide unique values from the data set: years, countries, commodities, transportation modes, and measures.

### Parameters

Commands like `monthly_total`, `monthly_average`, `yearly_total`, and `yearly_average` have parameters available for customization:

- `country` (default: "all")
- `commodity` (default: "all")
- `transport_mode` (default: "all")
- `measure` (default: "$")

## Goals for Week 3

During this week, you will:

- Implement OOP principles by building classes for each command.
- Write unit tests or integration tests for thorough testing.
- Utilize the `static` keyword, `final` keyword, and enumerations to enhance your code.
- Understand nested collections, generics, and lambda expressions.
- Develop a functional command-line tool with Java.
- Manage your project using Maven for efficient dependency management.

### Reflection

After completing the implementation, reflect on these questions to further improve your code and OOP understanding:

- How easy is it to add new commands to your program? Can you simplify this process?
- What if users prefer a UI over a command-line tool? How can you make this transition effortless?
- How could you enable writing results to a file instead of displaying them? How adaptable is your program to this change?
- Notice the common themes in the previous questions. What do these themes suggest about programming and programmatic solutions?

Object-Oriented Programming's strength lies in abstracting stakeholder requirements into versatile APIs that can be implemented differently through polymorphism. To achieve this, create classes/modules that function independently, encapsulating what they need to function.

_Note: This challenge assumes you can create basic Java programs, understand Java syntax, and work with classes, interfaces, collections, and generics. Edge cases and APIs can be looked up; you should already grasp the basics._

## Complementary Resources

- [The Forgotten History of OOP](https://blog.pragmaticengineer.com/the-forgotten-history-of-object-oriented-programming/)
- [How OOP Started](https://www.freecodecamp.org/news/the-history-of-object-oriented-programming-dbc93cd699b2/)
- [Meaning of OOP by Dr. Alan Kay](https://userpage.fu-berlin.de/~ram/pub/pub_jf47ht81Ht/doc_kay_oop_en)

## Tips

- Embrace change, as adaptability is crucial in software development.
- Remember that OOP is just one approach; it has both benefits and limitations.

## Evaluation

Evaluation criteria for this competency development:
- Implementation of all "commands" as classes.
- Writing unit tests for each class.
- Using Maven to manage the code base.
- Passing all tests and building the program without warnings or errors.

Keep up the great work and delve into the world of OOP with confidence!

