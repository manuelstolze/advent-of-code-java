# Spotless Pre-Commit Hook

This repository uses a pre-commit hook for spotless. It provides a script that installs a Git pre-commit hook that 
automatically runs the Spotless code formatter on all Java files before a commit enters the repository. This ensures 
that your code stays clean and consistent without manual formatting.

## 📜 Features

* Automatically formats Java code on every commit.
* Stages formatted changes automatically (git add .).
* Prevents unformatted code from entering the repository.
* Easy to install without manual configuration.

## ⚡ Installation

Run the installation script:

```
./install-precommit-hook.sh
```

### Note:

Make sure the script is located at the root of your project.

This script creates the hook at `.git/hooks/pre-commit` and makes it executable.

## 🏰 Usage

* Make changes to your code.
* Run git commit.
* Spotless will automatically format the code and stage any changes.
* The commit completes once all changes are cleanly formatted.


## ✅ Notes

* Ensure that Gradle and Spotless are set up in your project.
* The hook works locally; changes still need to be pushed to GitHub.
* The hook automatically stages formatted changes, so commit or stash uncommitted changes beforehand if needed.