# Day 14 — Advanced Locators Cheatsheet

## CSS Combinators

### Direct Child
div > input

Selects an input that is a direct child of a div.

### Adjacent Sibling
.label + div

Selects the immediately following sibling.

### General Sibling
.label ~ div

Selects later siblings that match the selector.

---

## CSS Pseudo-classes

### nth-child()
button:nth-child(3)

Targets an element based on its position among its siblings.

### :not()
input[type="text"]:not(.disabled)

Selects text inputs while excluding elements with the disabled class.

---

## XPath Axes

### parent::
//input[@id='username']/parent::div

Moves from an element to its parent.

### following-sibling::
//label[text()='Username']/parent::div/following-sibling::div[1]

Moves to the first matching following sibling.

---

## XPath Functions

### contains()
//button[contains(@id, 'save-button-')]

Useful when part of an attribute is stable.

### starts-with()
//button[starts-with(@id, 'submit-')]

Useful when the beginning of an attribute is stable.

### text()
//button[text()='Save Changes']

Matches exact text.

### normalize-space()
//button[normalize-space()='Save Changes']

Useful when extra whitespace may exist around text.

---

## Locator Strategy

Prefer:

1. Stable unique ID
2. Stable test-specific attribute
3. Stable name attribute
4. CSS selector
5. XPath when relationships or dynamic attributes require it

Avoid fragile locators that depend heavily on position or changing implementation details.

## Important Reminder

A syntactically valid locator is not automatically a good locator.

Always check:
- Does it uniquely identify the intended element?
- Is it stable?
- Will it survive reasonable UI changes?
- Is there a simpler locator?