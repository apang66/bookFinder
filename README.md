# bookFinder

## Technical Exercise
**User Story #1:** As a user, I would like to be able to enter an author's full or partial name on the screen, and have the screen
display for me the first 50 matches. The output should be the first 50 results of full author name + book title for authors
matching that search string. Any matches beyond the initial 50 do not need to be saved.

**User Story #2:** As a user, I would like to see all of the historical data of full author names and book titles that have matched my earlier search queries, with duplicates removed. Uniqueness is identified by the combination of full author name and book title.

## Approach
1. Set up environment
2. Build a basic API
3. Customize the API
4. Create the UI
5. Adjust for UX

## Challenges
### Google Books API
- The specification called for 50 total results, but the Google Volume:list API returns a maximum of 40.
- Search results would vary slightly with the exact same searches.
- Most of the pertinent information was nested a few layers deep in the response.
### CORS
- This was the most annoying hurdle.
### GitLens
- My React files won't show up in source control. I couldn't figure this out, so I attached the repo as a .7z.

## What would I change for production?
### Security
- Better structured API responses with errors
- Authentication
- Testing
### UX/UI
- Sorting
- Clear search
- Useful links (book info, rhumbnails, purchase links, etc.)

## Running Locally
1. ~~Clone the repository~~ Download the attached .7z file (bookFinder.7z), extract, and open in IDE.
2. Start React ```
    cd /src/main/ui
    yarn install
    yarn start```
3. Start Java by running BookFinderApplication.java

## Added Dependencies
- Styled Components (https://styled-components.com/)
- Chakra UI (https://chakra-ui.com/)
- React Hook Form (https://react-hook-form.com/)
- React JS Pagination (https://www.npmjs.com/package/react-js-pagination)
