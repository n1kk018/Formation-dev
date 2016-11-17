import { ProjetAngular2Page } from './app.po';

describe('projet-angular2 App', function() {
  let page: ProjetAngular2Page;

  beforeEach(() => {
    page = new ProjetAngular2Page();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
