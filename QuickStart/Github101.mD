# Basic Calculator App: GitHub Tutorial

## Introduction

**GitHub** is a powerful platform for code hosting, version control, and collaboration, allowing you to work with others on projects from anywhere. This tutorial introduces you to GitHub essentials using a basic calculator app as an example. You'll learn about repositories, branches, commits, and pull requests, key components of the GitHub workflow.

### Goals

- Create a repository for a basic calculator app
- Manage branches for feature development
- Make and commit code changes
- Open and merge a pull request

*Prerequisites:* A GitHub account, internet access, and basic understanding of programming. No prior experience with Git or command-line tools required.

## Step 1: Creating a Repository

A repository (repo) is like a project's folder containing all its files. For our basic calculator app, it will include source code, a README, and other documentation.

![Calculator Repo](/img/repo.png)


### Detailed Steps:

1. On GitHub, select the plus icon in the upper-right corner, then **New repository**.
2. Enter `basic-calculator` as your repository name.
3. Provide a brief description like "A simple calculator app in JavaScript."
4. Choose Public or Private visibility.
5. Initialize the repo with a README, which explains your project.
6. Consider adding a `.gitignore` file tailored for your project's language (e.g., Node for a JavaScript project).
7. Click **Create repository**.

## Step 2: Creating a Branch

Branches allow you to work on different versions of the repository simultaneously.

### Detailed Steps:

1. Navigate to your new `basic-calculator` repo.
2. Click the "main" branch dropdown. The main branch is your project's production branch.
3. Enter a new branch name, like `addition-feature`, for your feature.
4. Click **Create branch**.

## Step 3: Making and Committing Changes

Make changes in your new branch. Let's say you're adding an addition feature to the calculator.

### Detailed Steps:

1. In the `addition-feature` branch, click `calculator.js` (or your main app file).
2. Edit the file by adding code for the addition feature.
3. Write a clear commit message like "Add addition functionality."
4. Click **Commit changes** to save your changes.

## Step 4: Opening a Pull Request

Pull requests let you propose changes to the main branch. They are central to collaboration on GitHub.

### Steps:

1. Go to the **Pull requests** tab in your repo.
2. Click **New pull request**.
3. Select `addition-feature` as the branch to compare with `main`.
4. Review the diffs (changes) to ensure they're as intended.
5. Click **Create pull request**.
6. Add a descriptive title and summary of your changes.

## Step 5: Merging Your Pull Request

After review, merge your feature branch into the main branch.

![Merge and Pull Requests](https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.simplilearn.com%2Fpull-vs-merge-request-definition-differences-benefits-article&psig=AOvVaw1sUJ7rQi7bRBgspCGE0kwe&ust=1701289949084000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPCiuIrF54IDFQAAAAAdAAAAABAE)

### Detailed Steps:

1. Ensure your pull request has no conflicts with the base branch.
2. Click **Merge pull request** to combine your `addition-feature` branch with `main`.
3. Confirm by clicking **Confirm merge**.
4. It's good practice to delete the feature branch after merging.

## Conclusion and Next Steps

By following this tutorial, you've successfully used GitHub to develop a feature for a basic calculator app. This workflow is scalable for larger and more complex projects.

### Further Learning

- Explore **GitHub Flow** for more on branching and pull requests.
- Look into **GitHub Issues** for tracking tasks and bugs.
- Consider learning more about **Markdown** for better documentation.

For more resources and guides, visit the [GitHub Documentation](https://docs.github.com/en).