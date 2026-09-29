import { test, expect } from '@playwright/test';

test('Day 19 - Advanced Actions', async ({ page }) => {

    // -----------------------------
    // Exercise 1: Hover
    // -----------------------------

    await page.goto('https://the-internet.herokuapp.com/hovers');

    const firstImage = page.locator('.figure').first();

    await firstImage.hover();

    const profileLink = firstImage.getByRole('link', { name: 'View profile' });

    await expect(profileLink).toBeVisible();


    // -----------------------------
    // Exercise 2: JavaScript scroll
    // -----------------------------

    // -----------------------------
    // Exercise 3: Drag & Drop
    // -----------------------------

    await page.goto('https://jqueryui.com/droppable/');

    const demoFrame = page.frameLocator('.demo-frame');

    const draggable = demoFrame.locator('#draggable');

    const droppable = demoFrame.locator('#droppable');

    await draggable.dragTo(droppable);

    await expect(droppable).toContainText('Dropped!');
});