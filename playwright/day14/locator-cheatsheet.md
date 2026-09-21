# Day 14 — Advanced Locators: CSS & XPath

## Objective

Learn advanced CSS selectors and XPath techniques for locating difficult or dynamic web elements.

---

# 1. CSS Advanced Locators

## CSS Combinators

### `>` Direct Child

Selects an element that is a direct child of another element.

Example:

```css
div > input

Meaning: Find an input directly inside a div.

+ Adjacent Sibling

Selects the element immediately following another element.

Example:

div + div > input

Meaning: Find the next div sibling and then its direct input child.

~ General Sibling

Selects sibling elements that appear later under the same parent.

Example:

span.rc-tree-indent ~ span.rc-tree-checkbox

Meaning: Find the checkbox span that appears later than the indent span.

CSS Pseudo-Classes
:nth-child()

Selects an element based on its position among its siblings.

Example:

button:nth-child(2)

Meaning: Select the second child if it is a button.

:not()

Excludes elements matching a condition.

Example:

input:not([type="hidden"])

Meaning: Select inputs except those whose type is hidden.

2. XPath Advanced Locators
XPath Axes
parent::

Moves from an element to its parent.

Example:

//input[@id='userName']/parent::div

Meaning: Find the parent div of the userName input.

following-sibling::

Finds sibling elements that appear after the current element.

Example:

//label[@id='userName-label']/parent::div/following-sibling::div[1]

Meaning: Find the first div sibling after the label's parent.

3. XPath Functions
contains()

Matches when a string contains a specified value.

Example:

//button[contains(@id, 'submit-button')]

Useful for dynamic IDs where only part of the ID is stable.

starts-with()

Matches when a string starts with a specified value.

Example:

//button[starts-with(@id, 'save-')]

Useful when an element has a predictable ID prefix but a changing suffix.

text()

Matches an element based on its text.

Example:

//button[text()='Submit Form']

Useful when the button text is stable.

normalize-space()

Removes leading and trailing whitespace and normalizes whitespace before comparison.

Example:

//button[normalize-space()='Save Changes']

Useful when unexpected spaces or formatting make normal text comparison unreliable.

4. CSS vs XPath
CSS	XPath
Simple and readable	More powerful for relationships
Excellent for attributes	Supports parent and sibling axes
Good for simple element targeting	Useful for complex element relationships
Supports combinators	Supports functions and axes
> + ~	parent:: following-sibling::
5. Locator Stability

Prefer stable locators over fragile ones.

Recommended order:

Stable test ID such as data-testid or data-test
Stable ID
Stable name or meaningful attribute
Reliable CSS selector
Reliable XPath
Position-based selectors or indexes only when necessary

Avoid locators that depend heavily on:

Changing classes
Deep DOM structure
Multiple indexes
Visual position
Unstable generated IDs
Important Rule

If an XPath contains many indexes, consider refactoring it using a more stable attribute or relationship.

6. DemoQA Practical Locators

During Day 14, 15 difficult elements were located and verified on DemoQA.

#	Purpose	Locator
1	Direct child	div > input
2	Adjacent sibling	div + div > input
3	General sibling	span.rc-tree-indent ~ span.rc-tree-checkbox
4	Second child	button:nth-child(2)
5	Exclude hidden inputs	input:not([type="hidden"])
6	Parent element	//input[@id='userName']/parent::div
7	Following sibling	//label[@id='userName-label']/parent::div/following-sibling::div[1]
8	Dynamic ID with contains	//button[contains(@id, 'submit-button')]
9	Dynamic ID with starts-with	//button[starts-with(@id, 'save-')]
10	Exact button text	//button[text()='Submit Form']
11	Normalized button text	//button[normalize-space()='Save Changes']
12	ID attribute	//input[@id='userName']
13	Attribute-based CSS	input[placeholder='Full Name']
14	Label element	//label[@id='userName-label']
15	Checkbox by accessible label	//span[@aria-label='Select Home']
7. DevTools Validation

DevTools can be used to test selectors before using them in automation code.

CSS Selector
$('input#userName')

Returns the first matching element.

$$('input')

Returns all matching elements.

XPath

Chrome DevTools also supports:

$x("//input[@id='userName']")

This returns elements matching the XPath.

8. Key Differences to Remember
CSS

Think:

"Where is the element in relation to other elements?"

Examples:

div > input
div + div
span ~ span
XPath

Think:

"How can I navigate from this element to another element?"

Examples:

parent::div
following-sibling::div

And:

"How can I match changing or specific values?"

Examples:

contains()
starts-with()
text()
normalize-space()
9. Day 14 Quick Revision
Concept	Meaning
>	Direct child
+	Immediate next sibling
~	Later sibling
:nth-child()	Select by position
:not()	Exclude a condition
parent::	Move to parent
following-sibling::	Find later siblings
contains()	Partial string match
starts-with()	Prefix string match
text()	Match text
normalize-space()	Normalize whitespace before comparison
10. Day 14 Practical Workflow

When an element is difficult to locate:

Inspect the element in DevTools.
Look for stable attributes.
Try a simple CSS selector first.
Use CSS combinators when elements have a relationship.
Use XPath when parent/sibling navigation is useful.
Use contains() or starts-with() for dynamic values.
Validate the locator in DevTools.
Use the verified locator in Playwright.
Avoid unnecessary indexes.
Prefer stable and readable locators.
Day 14 Deliverable

File: day14/locator-cheatsheet.md

Practice Site: DemoQA

Practice Completed: 15 difficult elements

Topics Covered:

Advanced CSS combinators
CSS pseudo-classes
XPath axes
XPath functions
Dynamic IDs
Text-based XPath
Whitespace normalization
Locator stability
DevTools validation

Day 14 Status: Completed