import { test, expect } from '@playwright/test';

test.beforeEach(async ({ page }) => {
  await page.goto('https://demoqa.com/browser-windows');
});

test('handle parent and child windows @regression', async ({ page, context }) => {

  // 1. PARENT PAGE
  const parentPage = page;

  await expect(parentPage.locator('h1'))
    .toHaveText('Browser Windows');

  // 2. CLICK NEW TAB AND CAPTURE CHILD PAGE
  const childPagePromise = context.waitForEvent('page');

  await parentPage.getByRole('button', { name: 'New Tab' }).click();

  const childPage = await childPagePromise;

  // 3. VERIFY CHILD PAGE
  await expect(childPage.locator('#sampleHeading'))
    .toHaveText('This is a sample page');

  // 4. CLOSE CHILD PAGE
  await childPage.close();

  // 5. VERIFY PARENT PAGE IS STILL OPEN
  await expect(parentPage.locator('h1'))
    .toHaveText('Browser Windows');

  await expect(parentPage)
    .toHaveURL(/browser-windows/);
});
