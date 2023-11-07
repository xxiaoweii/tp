---
layout: default.md
title: "User Guide"
pageNav: 3
---

# NUSearch User Guide

NUSearch is a **desktop app for consolidating NUS professors, teaching assistants (TAs) and students’ profiles, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a **Graphical User Interface (GUI)**. If you can type fast, NUSearch add and search for your NUS peers and mentors faster than traditional GUI apps.

--- {.dotted .thick-1 .border-primary}
## Motivation
We aim to simplify the process of accessing academic information by developing an efficient directory app. This app will help students to consolidate professors, teaching assistants (TAs) and their fellow classmates’ profile, improving the ease of accessing the details of individuals whom the students might need to contact for that semester.

--- {.dotted .thick-1 .border-primary}
## Unique Selling Point
The app helps students to consolidate important data, such as profiles of professors, teaching assistants (TAs), and fellow classmates, providing students with a single platform that is compact and easy to navigate. With this application, students can save time and energy that would otherwise be spent searching for scattered and hard-to-access essential academic contacts. The app features an intuitive and user-friendly interface, making it convenient for users to quickly find the information they need.

--- {.dotted .thick-1 .border-primary}
## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. to be added

3. Refer to the [Features](#features) below for details of each command.

--- {.dotted .thick-1 .border-primary}

## Features

### A guide to reading each feature
This section will guide you through how to interpret the description and the command format of each feature. 

##### The description of each feature will contain the following:

###### WHAT IT DOES:
Tells you the basic idea of what the command does.

###### FORMAT:
It specifies how the command should be formatted. You should follow the format specified to ensure that the command gives the desired output.

###### EXAMPLE COMMAND:
Gives you a few examples of how the command can be used for reference.

###### ACCEPTABLE VALUES:
Describes the accepted values used in a command field, specifying any restrictions. Values for the command must satisfy the restrictions for the command to be accepted.

###### EXPECTED OUTPUT ON SUCCESS:
Describes the desired output that you would see when the command is valid.

###### EXPECTED OUTPUT ON FAILURE:
Shows the error messages that will be shown to you if an invalid command is given.

##### How to interpret a command format:

###### COMMAND FORMAT
```
command --specifier INPUTFIELD [--specifier INPUTFIELD1, ...] [--specifier INPUTFIELD1/SUBFIELD1-SUBFIELD2-..., ...]
```
<box type="warning">
    Note that a command is case-sensitive; in other words, "add" is different from "ADD" and "Add"; be careful not to mix them up!
</box>

###### EXAMPLE COMMAND FORMAT
```
add --name NAME [--role ROLE1, ...]  [--contact CONTACT1, ...] [--course COURSECODE1/CLASS1-CLASS2-..., ...] 
```

| Command Types |          Examples           | What they mean                                                                                              |
|:-------------:|:---------------------------:|-------------------------------------------------------------------------------------------------------------|
|   `command`   |            `add`            | The name of the command. It is in bold in the format.                                                       |
| `--specifier` |          `--name`           | The specifier of the field to indicate the field type.                                                      |
| `INPUTFIELD`  |           `NAME`            | The content of the INPUT FIELD the user wants to input.                                                     |
|     `...`      |       `CONTACT1, ...`       | Ellipses indicate that the field can accept multiple values.                                                |
| ` [ ] ` | `[--contact CONTACT1, ...]` | Square brackets indicate an optional field. The user can input these fields if they want to in the command. |
| `, ` |       `CONTACT1, ...`       | Comma separates the multiple INPUTFIELDs                                                                    |
| `INPUTFIELD/SUBFIELD` |     `COURSECODE/CLASS`      | Slash indicates that this INPUTFIELD can have a SUBFIELD. This SUBFIELD is optional.                        |
| `SUBFIELD1-SUBFIELD2` |    `CLASS1-CLASS2-...`      | Dash separates the multiple SUBFIELDs.                                                                      |

###### VALID SPECIFIERS

|  Specifier  | Purpose                                          |
|:-----------:|--------------------------------------------------|
|  `--name`   | The name of the person you are adding            |
|  `--role`   | The role of the person you are adding            |
| `--contact` | The contact details of the person you are adding |
| `--course`  | The course the person is taking                  |


### Help page: `help`

Show the help page of the application

###### FORMAT:
`help`

###### EXAMPLE COMMAND:
`help`

###### ACCEPTABLE VALUES:
This command does not accept any parameters

###### EXPECTED OUTPUT ON SUCCESS:

```
Quick Guide: 
Adding a person: add --name NAME [--role ROLE1, ...]  [--contact CONTACT1, ...] [--course COURSECODE1/CLASS1-CLASS2-..., ...]
Listing all persons: list
Deleting a profile: delete INDEX
Search by name: search NAME
Search by role: searchrole ROLE
Search by course: searchcourse COURSE
Search by tutorial class: searchtutorial TUTORIAL
Edit current profile by deleting current information: edit --delete
Edit current profile by adding new information: edit --add
Edit current profile by changing current information: edit --change
Adding profiles to favourites: fav INDEX
Refer to the User Guide for the detailed implementation.
```
A help window will pop out as shown: [Help Window](./images/HelpWindow.png)

###### EXPECTED OUTPUT ON FAILURE:

This command only recognises `help` as the keyword.

Any other command word such as `h`, `he` and `hel` will be seen as an invalid command with the following output:

`Unknown command`

### Adding a person: `add`

Adds new profiles in the profile lists.

###### FORMAT:
`add --name NAME [--role ROLE1, ...]  [--contact CONTACT1, ...] [--course COURSECODE1/CLASS1-CLASS2-..., ...] `

<box type="tip" seamless>

**Tip:**

-The input for role is case-sensitive

-Contacts can be any type of contact: email address, telegram handle, phone number, etc.

-Courses can be any of the courses offered by NUS

-Courses can be added without the tutorial classes but tutorial classes must be added with a course 
(see Example 2 below for more details)

> 📝Note:
>
> Please use a comma (,) to separate the different roles, contacts and courses

-The different fields are colour-coded to differentiate between them.

-The user can press tab to auto fill commands.

-The square brackets, [ ], are not needed when entering the command (see Example 3 below for more details)

</box>

###### EXAMPLE COMMAND:

Example 1:

`add --name Aiken Dueet --role Student --contact @aikendueet, aikendueet@gmail.com
--course CS2103T/Tut8, CS2100/Lab40-Tut30`

Example 2:

`add --name Charlie Dueet --role TA, Student --contact @charliee, charliee@gmail.com
--course GEA1000, QF2103`

Example 3:

`add --name Daycon Dueet`

###### ACCEPTABLE VALUES:
`NAME`: Any non-empty input of alphabetical characters.

`ROLE1`: Any three roles allowed here: Student, TA, Professor

`CONTACT1`: Any non-empty input of characters.

`COURSECODE1`: Any non-empty input of characters.

`CLASS1`: Any non-empty input of characters.

###### EXPECTED OUTPUT ON SUCCESS:

Example 1:

```
You have added a new profile in : 
 Name: Aiken Dueet; Role: Student; Contacts: [@aikendueet], [aikendueet@gmail.com]; Courses: CS2103T, CS2100; Tutorials: CS2103T/Tut8, CS2100/Lab40-Tut30
```

Example 2:

```
You have added a new profile in :
 Name: Charlie Dueet; Role: Student, TA; Contacts: [@charliee]; Courses: CS2103T, CS2101, CS2100; Tutorials: 
```

Example 3:

```
You have added a new profile in :
Name: Daycon Dueet; Role: ; Contact: ; Course: ; Tutorials: 
```

###### EXPECTED OUTPUT ON FAILURE:

**For invalid `add` command:** 

Example: `add --`

```
Invalid command format! 
add: Adds a person to the address book. 
Parameters: --name NAME  [--role ROLE1,...] [--contact CONTACT1, ...]  [--course COURSECODE1/CLASS1-CLASS2-..., ...]
Example: add --name John --role Developer, Designer --contact johnd@example.com, 98765432 --course CS2103T/G06, CS2101/G06, CS2100/T24-Lab36
```

**For wrong format:**

Example: `add --name`

`Names should only contain alphanumeric characters and spaces, and it should not be blank`

Example: `add --name Charlie --role teacher`

`A role must take one of the roleTypes: Student, TA, or Professor.`

Example: `add --name Charlie --role TA --course CS21111`

```
INVALID COURSE FORMAT!
COURSE CODE SHOULD BE IN THE FOLLOWING FORMAT: 
 1. Starts with two- or three-letter prefix
 2. Follows by four digits, first of which indicates the level of the course
 3. Can end with a letter
 ```

Example: `add --name Charlie --role TA --course CS2100/         F09`

`Tutorials should be written in the format COURSECODE/TUTORIAL`


### Listing all persons : `list`

List all the profiles added by the user.

###### FORMAT:
`list`

###### EXAMPLE COMMAND:
`list`

###### ACCEPTABLE VALUES:
This command does not accept any parameters.

###### EXPECTED OUTPUT ON SUCCESS:
```
You have 1 profile in your list: 
Name: Aiken Dueet  
Role: STUDENT
Contact: @aikendueet, aikendueet@gmail.com
Course: CS2103T, CS2101, CS2100
Tutorials: CS2103T/Tut8 , CS2101/G06, CS2100/Lab40-Tut30 
```

###### EXPECTED OUTPUT ON FAILURE:
This command only recognises `list` as the keyword. 

Any other command word such as `l`, `li` and `lis` will be seen as an invalid command with the following output:

`Unknown command`


### Adding profiles to favourites: `fav`

Favourite the profiles in the user’s current profile list.

###### FORMAT:
`fav INDEX`

###### EXAMPLE COMMAND:
`fav 2`

###### ACCEPTABLE VALUES:
`INDEX`: Any number representing a positive integer (i.e. 1, 2, 3, …),
less than or equal to the number of profiles the user currently has.

> 📝Note:
>
> INDEX refers to the index of the profile allocated to the specific profile in the current profile list.

###### EXPECTED OUTPUT ON SUCCESS:
```
Favourited Person: Name: Alex Yeoh; Role: Student; Contacts: [alexyeoh@example.com]; Courses: CS1101; Tutorials: CS1101/T03E
```

###### EXPECTED OUTPUT ON FAILURE:
**For invalid index:**

Example `fav -1`

```
Invalid command format! 
fav: Favourites the person identified by the index number used in the displayed person list. 
Parameters: INDEX (must be a positive integer)
Example: fav 1
 ```

**For index out of bound:**

Example: `fav 100` [Assuming the address book currently contains 10 profiles]

`The person index provided is invalid`

### Removing a profile from favourite: `unfav`

Un-favourite a favourite profile

###### FORMAT:
`unfav INDEX`

###### EXAMPLE COMMAND:
`unfav 2`

###### ACCEPTABLE VALUES:
`INDEX`: Any number representing a positive integer (i.e. 1, 2, 3, …),
less than or equal to the number of profiles the user currently has.

> 📝Note:
>
> INDEX refers to the index of the profile allocated to the specific profile in the current profile list.

###### EXPECTED OUTPUT ON SUCCESS:
```
Unfavourited Person: Name: Alex Yeoh; Role: Student; Contacts: [alexyeoh@example.com]; Courses: CS1101; Tutorials: CS1101/T03E
```

###### EXPECTED OUTPUT ON FAILURE:
**For invalid index:**

Example `unfav -1`

```
Invalid command format! 
unfav: Unfavourites the person identified by the index number used in the displayed person list. 
Parameters: INDEX (must be a positive integer)
Example: unfav 1
 ```

**For index out of bound:**

Example: `unfav 100` [Assuming the address book currently contains 10 profiles]

`The person index provided is invalid`


### Listing all favourite persons : `favlist`

List all the profiles favourited by the user.

###### FORMAT:
`favlist`

###### EXAMPLE COMMAND:
`favlist`

###### ACCEPTABLE VALUES:
This command does not accept any parameters.

###### EXPECTED OUTPUT ON SUCCESS:
```
You have 1 favourited profile in your list. 
Name: Aiken Dueet  
Role: STUDENT
Contact: @aikendueet, aikendueet@gmail.com
Course: CS2103T, CS2101, CS2100
Tutorials: CS2103T/Tut8 , CS2101/G06, CS2100/Lab40-Tut30 
```

###### EXPECTED OUTPUT ON FAILURE:
This command only recognises `favlist` as the keyword.

Any other command word such as `favl`, `favli` and `favlis` will be seen as an invalid command with the following output:

`Unknown command`

### Deleting a profile : `delete`

Delete the specific profile based on the index allocated to the profile.

###### FORMAT:
`delete INDEX`

###### EXAMPLE COMMAND:
`delete 1`

###### ACCEPTABLE VALUES:
`INDEX`: Any number representing a positive integer (i.e. 1, 2, 3, …),
less than or equal to the number of profiles the user currently has.

###### EXPECTED OUTPUT ON SUCCESS:
```
Deleted person: Deleted Person: Name: Aiken Dueet; Role: Student; Contacts: [@aikendueet], [aikendueet@gmail.com]; Courses: CS2103T; Tutorials: CS2103T/Tut8
```

###### EXPECTED OUTPUT ON FAILURE:
**For invalid index:**

Example: `delete -1`

```
Invalid command format! 
delete: Deletes the person identified by the index number used in the displayed person list.
Parameters: INDEX (must be a positive integer)
Example: delete 1
```

**For out of bound index:**

Example: `delete 100` [Assuming the address book currently contains 10 profiles]

`The person index provided is invalid`

### Searching for profiles by name: `search`

Search for profiles using name.

Output profiles which match the given name.

> Note: The input name is NOT case-sensitive.

###### FORMAT:
`search NAME`

###### EXAMPLE COMMAND:
`search Charlie`

###### ACCEPTABLE VALUES:
`NAME`: Any non-empty string of alphanumeric characters (not case-sensitive).

###### EXPECTED OUTPUT ON SUCCESS:
```
1 persons found!
```

###### EXPECTED OUTPUT ON FAILURE:
**For incomplete command:** 

Example: `search   `

```
Invalid command format!
search: Finds all persons whose names contain any of the specified keywords (case-insensitive) and displays them as a list with index numbers.
Parameters: KEYWORD [MORE_KEYWORDS]...
Example: search alice bob charlie
```

### Searching for profiles by course: `searchcourse`

Search for profiles using course.

Output profiles which match the given course.

> Note: The input course is NOT case-sensitive.

###### FORMAT:
`searchcourse COURSECODE`

###### EXAMPLE COMMAND:
`searchcourse CS2100`

###### ACCEPTABLE VALUES:
`COURSECODE`: A valid course code that fulfills the following criteria (not case-sensitive):
1. Starts with two- or three-letter prefix
2. Follows by four digits, first of which indicates the level of the course
3. Can end with a letter

###### EXPECTED OUTPUT ON SUCCESS:
```
1 persons found!
```

###### EXPECTED OUTPUT ON FAILURE:
**For incomplete command:**

Example: `searchcourse    `

```
Invalid command format!
searchcourse: Finds all persons whose courses contain any of the specified keywords (case-insensitive) and displays them as a list with index numbers.
Parameters: KEYWORD [MORE_KEYWORDS]...
Example: searchcourse alice bob charlie
```

### Searching for profiles by role: `searchrole`

Search for profiles using role.

Output profiles which match the given role.

> Note: The input role is NOT case-sensitive.

###### FORMAT:
`searchrole ROLE`

###### EXAMPLE COMMAND:
`searchrole TA`

###### ACCEPTABLE VALUES:
`ROLE`:

A valid role type: 

1. TA
2. Student
3. Professor

###### EXPECTED OUTPUT ON SUCCESS:
```
0 persons found!
```

###### EXPECTED OUTPUT ON FAILURE:
**For incomplete command:**

Example: `searchrole    `

```
Invalid command format!
searchrole: Finds all persons whose names contain any of the specified keywords (case-insensitive) and displays them as a list with index numbers.
Parameters: KEYWORD [MORE_KEYWORDS]...
Example: searchrole alice bob charlie
```

### Searching for profiles by tutorial: `searchtutorial`

Search for profiles using tutorial class.

Output profiles which match the given tutorial class.

> Note: The input tutorial is NOT case-sensitive.

###### FORMAT:
`searchtutorial TUTORIAL`

###### EXAMPLE COMMAND:
`searchtutorial CS2100/Tut8`

###### ACCEPTABLE VALUES:
`TUTORIAL`: A valid tutorial in the format: COURSECODE/TUTORIAL.

###### EXPECTED OUTPUT ON SUCCESS:
```
0 persons found!
```

###### EXPECTED OUTPUT ON FAILURE:
**For incomplete command:**

Example: `searchtutorial    `

```
Invalid command format!
searchtutorial: Finds all persons whose names contain any of the specified keywords (case-insensitive) and displays them as a list with index numbers.
Parameters: KEYWORD [MORE_KEYWORDS]...
Example: searchtutorial alice bob charlie
```

### Editing a profile: `edit`

Edits all fields in the current profile

###### FORMAT:
`edit INDEX [--name NAME] [--role ROLE1, ...]  [--contact CONTACT1, ...] [--course COURSECODE1/CLASS1-CLASS2-..., ...]`

###### EXAMPLE COMMAND:
`edit 1 --name Aiken Dueet --role Student --contact @aikenduee --course CS2103T/Tut8, CS2101/G06, CS2100/Lab40-Tut30`

###### ACCEPTABLE VALUES:
`INDEX`: Any number representing a positive integer (i.e. 1, 2, 3, …), less than or equal to the number of profiles the user currently has.

`NAME`: Any non-empty input of alphabetical characters.

`ROLE`: Any three roles allowed here: Student, TA, Professor.

`CONTACT`: Any non-empty input of characters.

`COURSECODE`: Any non-empty input of characters.

###### EXPECTED OUTPUT ON SUCCESS:
```
You have edited person 1 in the profile to: 
 Name: Aiken Dueet; Role: Student; Contacts: [@aikendueet]; Courses: CS2103T, CS2101, CS2100; Tutorials: CS2103T/Tut8, CS2101/G06, CS2100/Lab40-Tut30
 ```

###### EXPECTED OUTPUT ON FAILURE:
**For invalid index:**

Example `edit -1`
```
Invalid command format!
edit: Edits the person identified by the index number used in the displayed person list.
Parameters: INDEX [--name NAME] [--role ROLE1, ...]  [--contact CONTACT1, ...] [--course COURSECODE1/CLASS1-CLASS2-..., ...]
Example: edit 1 --name John --role Student
```

**For index out of bound:**

Example: `edit 100` [Assuming the address book currently contains 10 profiles]

`The person index provided is invalid`

### Exiting the application: `exit`

Closes and exits the application

###### FORMAT:
`exit`

###### EXAMPLE COMMAND:
`exit`

###### ACCEPTABLE VALUES:
This command does not accept any parameters

###### EXPECTED OUTPUT ON SUCCESS:
There will be no output 

The application will close

###### EXPECTED OUTPUT ON FAILURE:
This command only recognises `exit` as the keyword.

Any other command word such as `e`, `ex` and `exi` will be seen as an invalid command with the following output:

`Unknown command`

### Autocomplete
What if you needed to quickly write a command? Well, Autocomplete feature is here to save you!

All you need to do is: type your command, and then press Tab for it to suggest the next command!

For example, pressing `f` and then `<Tab>` will let the program automatically suggest the `fav` command. You can continue pressing `<Tab>` to cycle through the list of commands. For instance, pressing `<Tab>` again after it suggests `fav` will cause it to autocomplete `favlist` instead. After cycling through all possible autocompletions, it will cycle back to your original input, if you want to amend it some more.

--- {.dotted .thick-1 .border-primary}

## UI Mockup

Here's a mockup of how the User Interface might look: <br>

![NUSearch UI Mockup](./images/Ui.png)

--- {.dotted .thick-1 .border-primary}

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--- {.dotted .thick-1 .border-primary}

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--- {.dotted .thick-1 .border-primary}

## Command summary

|     Action     | Format                                                                                                          | Example                                                                                                                                   |
|:--------------:|-----------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
|    **Help**    | `help`                                                                                                          | `help`                                                                                                                                    |                                                                                                                                  
|    **Add**     | `add --name NAME [--role ROLE1, ...]  [--contact CONTACT1, ...] [--course COURSECODE1/CLASS1-CLASS2-..., ...]`  | `add --name Aiken Dueet --role Student --contact @aikendueet, aikendueet@gmail.com --course CS2103T/Tut8, CS2101/G06, CS2100/Lab40-Tut30` |
|    **List**    | `list`                                                                                                          | `list`                                                                                                                                    |
|   **Delete**   | `delete INDEX`                                                                                                  | `delete 3`                                                                                                                                |
|   **Search by Name**   | `search KEYWORD`                                                                                                  | `search Alex`                                                                                                                             |
|   **Search by Role**   | `searchrole KEYWORD`                                                                                                  | `searchrole TA`                                                                                                                             |
|   **Search by Course**   | `searchcourse KEYWORD`                                                                                                  | `searchcourse CS2100`                                                                                                                             |
|   **Search by Tutorial**   | `searchtutorial KEYWORD`                                                                                                  | `searchtutorial CS2100/G06`                                                                                                                             |
| **Favourite**  | `fav INDEX`                                                                                                     | `fav 1`                                                                                                                                   |
|    **Exit**    | `exit`                                                                                                          | `exit`                                                                                                                                    | 


