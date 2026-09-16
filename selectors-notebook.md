\# Day 11 — HTML, CSS \& DOM Selectors Notebook



\## Objective



Practice inspecting real webpages using DevTools and creating CSS selectors that uniquely identify buttons, inputs, and links.



\### Sites Practiced



1\. The Internet — https://the-internet.herokuapp.com/

2\. SauceDemo — https://www.saucedemo.com/

3\. DemoQA — https://demoqa.com/elements



\---



\# Site 1 — The Internet



\## Selectors



| #  | Target              | CSS Selector                                           | DevTools Check     |

| -- | ------------------- | ------------------------------------------------------ | ------------------ |

| 1  | GitHub link         | `a\[href="https://github.com/tourdedave/the-internet"]` | `length = 1`       |

| 2  | A/B Testing         | `a\[href="/abtest"]`                                    | `length = 1`       |

| 3  | Form Authentication | `a\[href="/login"]`                                     | `length = 1`       |

| 4  | Checkboxes          | `a\[href="/checkboxes"]`                                | `length = 1`       |

| 5  | Dropdown            | `li a\[href="/dropdown"]`                               | Verify             |

| 6  | Checkboxes          | `li > a\[href="/checkboxes"]`                           | Verify             |

| 7  | Text input          | `input\[type="text"]`                                   | Verify             |

| 8  | Add/Remove Elements | `a\[href="/add\_remove\_elements/"]`                      | Verify             |

| 9  | Internal links      | `a\[href^="/"]`                                         | May match multiple |

| 10 | GitHub links        | `a\[href\*="github"]`                                    | Verify             |



\## DevTools Commands



Use `$()` to test one selector:



```javascript

$('a\[href="/login"]')

```



Use `$$()` to inspect all matching elements:



```javascript

$$('a\[href^="/"]')

```



\### Key observation



A selector is more useful for automation when it identifies the intended element uniquely.



`length = 1` indicates that the selector currently matches one element.



\---



\# Site 2 — SauceDemo



\## Selectors



| #  | Target       | CSS Selector                        | Expected Match |

| -- | ------------ | ----------------------------------- | -------------- |

| 1  | Username     | `input#user-name`                   | `length = 1`   |

| 2  | Password     | `input#password`                    | `length = 1`   |

| 3  | Login button | `input#login-button`                | `length = 1`   |

| 4  | Username     | `input\[name="user-name"]`           | `length = 1`   |

| 5  | Password     | `input\[name="password"]`            | `length = 1`   |

| 6  | Username     | `input\[placeholder="Username"]`     | `length = 1`   |

| 7  | Password     | `input\[placeholder="Password"]`     | `length = 1`   |

| 8  | Login button | `input\[type="submit"]#login-button` | `length = 1`   |

| 9  | Login button | `input\[value="Login"]`              | `length = 1`   |

| 10 | Login button | `form > input\[type="submit"]`       | `length = 1`   |



\## Selector Types Practiced



\### ID selector



```css

input#user-name

```



\### Attribute selector



```css

input\[name="password"]

```



\### Multiple conditions



```css

input\[type="submit"]#login-button

```



\### Parent → direct child



```css

form > input\[type="submit"]

```



\---



\# Site 3 — DemoQA



\## Selectors



| #  | Target            | CSS Selector                            | Expected Match |

| -- | ----------------- | --------------------------------------- | -------------- |

| 1  | Full Name         | `input#userName`                        | `length = 1`   |

| 2  | Email             | `input#userEmail`                       | `length = 1`   |

| 3  | Current Address   | `textarea#currentAddress`               | `length = 1`   |

| 4  | Permanent Address | `textarea#permanentAddress`             | `length = 1`   |

| 5  | Submit            | `button#submit`                         | `length = 1`   |

| 6  | Full Name         | `input\[placeholder="Full Name"]`        | `length = 1`   |

| 7  | Email             | `input\[placeholder="name@example.com"]` | `length = 1`   |

| 8  | Text Box          | `a\[href="/text-box"]`                   | Verify         |

| 9  | Check Box         | `a\[href="/checkbox"]`                   | Verify         |

| 10 | Radio Button      | `a\[href="/radio-button"]`               | Verify         |



\---



\# CSS Selector Reference



\## 1. Descendant Selector



```css

.login button

```



Selects a `button` anywhere inside `.login`.



\*\*Space = descendant\*\*



\---



\## 2. Child Selector



```css

.login > button

```



Selects a `button` that is a direct child of `.login`.



\*\*`>` = direct child\*\*



\---



\## 3. Attribute Selector



```css

input\[id="password"]

```



Selects an `input` whose `id` attribute has the value `password`.



General pattern:



```css

element\[attribute="value"]

```



\---



\## 4. ID Selector



```css

\#loginBtn

```



or:



```css

button#loginBtn

```



Targets an element using its `id`.



\---



\## 5. Attribute Starts With



```css

a\[href^="/"]

```



`^=` means the attribute value \*\*starts with\*\* the specified value.



\---



\## 6. Attribute Contains



```css

a\[href\*="github"]

```



`\*=` means the attribute value \*\*contains\*\* the specified value.



\---



\# DevTools Console



\## `$()`



Returns the first matching element.



```javascript

$('button')

```



Think:



\*\*`$()` → one\*\*



\---



\## `$$()`



Returns all matching elements.



```javascript

$$('button')

```



Think:



\*\*`$$()` → all\*\*



\---



\# Selector Validation Workflow



When creating a selector:



```text

Inspect element

&#x20;     ↓

Understand HTML + attributes

&#x20;     ↓

Create CSS selector

&#x20;     ↓

Test using $()

&#x20;     ↓

Check length

&#x20;     ↓

Refine if necessary

&#x20;     ↓

Record selector

```



\### Example



HTML:



```html

<a href="/login">Form Authentication</a>

```



Selector:



```css

a\[href="/login"]

```



Validation:



```javascript

$('a\[href="/login"]')

```



Result:



```text

length = 1

```



Therefore, the selector uniquely identifies the element on the page at the time of testing.



\---



\# Key Day 11 Takeaways



\* HTML provides the structure of a webpage.

\* Attributes provide additional information about HTML elements.

\* The DOM represents webpage elements as a tree of nodes.

\* Parent, child, and sibling relationships help understand element structure.

\* CSS selectors identify elements in the DOM.

\* A space creates a descendant relationship.

\* `>` identifies a direct child.

\* Attribute selectors can target elements using attribute names and values.

\* `$()` can be used to inspect the first matching element in the DevTools console.

\* `$$()` can be used to inspect all matching elements.

\* Selector uniqueness can be checked by examining the number of matched elements.



\---



\# Day 11 Deliverable



\*\*File:\*\* `selectors-notebook.md`



\*\*Repository:\*\* `qa-upskilling-45`



\*\*Practice completed:\*\*



\* \[x] HTML structure

\* \[x] Semantic tags

\* \[x] Attributes

\* \[x] CSS selectors

\* \[x] DOM tree

\* \[x] DevTools

\* \[x] `$()`

\* \[x] `$$()`

\* \[x] Site 1 selector practice

\* \[x] Site 2 selector practice

\* \[x] Site 3 selector practice

\* \[ ] Commit Markdown notebook to GitHub



