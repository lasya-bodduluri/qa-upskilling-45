import { test, expect } from '@playwright/test';

test('Day 16 - Form Automation', async ({ page }) => {

    await page.goto('https://www.selenium.dev/selenium/web/web-form.html');

    // --------------------------------
    // 1. TEXT INPUT
    // --------------------------------

    const textInput = page.locator('[name="my-text"]');

    await expect(textInput).toBeVisible();
    await expect(textInput).toBeEnabled();

    await textInput.fill('Lasya');

    await expect(textInput).toHaveValue('Lasya');


    // --------------------------------
    // 2. CLEAR AND RE-ENTER
    // --------------------------------

    await textInput.clear();

    await textInput.fill('QA Automation');

    await expect(textInput).toHaveValue('QA Automation');


    // --------------------------------
    // 3. GET ATTRIBUTE
    // --------------------------------


    // --------------------------------
    // 4. NATIVE DROPDOWN
    // --------------------------------

    const dropdown =
        page.locator('[name="my-select"]');

    await dropdown.selectOption({label: 'Two'});

    await expect(dropdown).toHaveValue('2');


    // --------------------------------
    // 5. CHECKBOX
    // --------------------------------

    const checkbox = page.locator('#my-check-1');

    await checkbox.check();

    await expect(checkbox).toBeChecked();


    // --------------------------------
    // 6. RADIO BUTTON
    // --------------------------------

    const radio = page.locator('#my-radio-2');

    await radio.check();

    await expect(radio).toBeChecked();


    // --------------------------------
    // 7. SUBMIT BUTTON
    // --------------------------------

    const submitButton = page.locator('button');

    await expect(submitButton).toBeVisible();
    await expect(submitButton).toBeEnabled();

    await expect(submitButton).toHaveText('Submit');


    // --------------------------------
    // 8. CLICK SUBMIT
    // --------------------------------

    await submitButton.click();


    // --------------------------------
    // 9. VERIFY RESULT
    // --------------------------------

    await expect(page).toHaveURL(/submitted-form/);

});