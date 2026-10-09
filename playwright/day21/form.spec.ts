
import { test, expect } from '@playwright/test';

test.beforeEach(async ({ page }) => {
    await page.goto('https://www.selenium.dev/selenium/web/web-form.html');
});

test('form automation @regression', async ({ page }) => {

    // 1. TEXT INPUT
    const textInput = page.locator('[name="my-text"]');

    await expect(textInput).toBeVisible();
    await expect(textInput).toBeEnabled();

    await textInput.fill('Lasya');

    await expect(textInput).toHaveValue('Lasya');

    // clear() and re-entry
    await textInput.clear();
    await textInput.fill('QA Automation');

    await expect(textInput).toHaveValue('QA Automation');

    // 2. GET ATTRIBUTE
    const placeholder = await textInput.getAttribute('placeholder');

    // 3. DROPDOWN
    const dropdown = page.locator('[name="my-select"]');

    await dropdown.selectOption({ label: 'Two' });

    await expect(dropdown).toHaveValue('2');

    // 4. CHECKBOX
    const checkbox = page.locator('#my-check-1');

    if (!(await checkbox.isChecked())) {
        await checkbox.check();
    }

    await expect(checkbox).toBeChecked();

    // 5. RADIO BUTTON
    const radio = page.locator('#my-radio-2');

    await radio.check();

    await expect(radio).toBeChecked();

    // 6. SUBMIT BUTTON
    const submitButton = page.locator('button');

    await expect(submitButton).toBeVisible();
    await expect(submitButton).toBeEnabled();

    // 7. SUBMIT
    await submitButton.click();

    // 8. VERIFY RESULT
    await expect(page).toHaveURL(/submitted-form/);
});