# mgit

A minimal Git implementation written in Clojure (Babashka) as a learning exercise to understand Git internals by building a simplified version from scratch.

## Reference

This implementation is based on the following Zenn book:

https://zenn.dev/ryu_9845343/books/fc32a59e1a3807

and references the Erlang (escript) implementation [radish-miyazaki/mgit-escript](https://github.com/radish-miyazaki/mgit-escript).

## Features

- `init` - Initialize a new mgit repository (creates `.mgit` directory with `objects`, `refs/heads`, `HEAD`, and `index`)
- `add <filename>` - Stage a file to the index (computes SHA-1 hash, stores the object, and updates the index)
- `commit <message>` - Create a commit from the current index (stores tree, parent, and message as an object, and updates the branch reference)
- `log` - Show commit history by walking from HEAD through parent references
- `branch <branch_name>` - Create a new branch that points at the current HEAD commit
- `checkout <branch_or_commit>` - Move HEAD to a branch ref or detach it at a commit hash

## Usage

```sh
# Make the script executable
chmod +x mgit

# Initialize a repository
./mgit init

# Stage a file
./mgit add <filename>

# Create a commit
./mgit commit "initial commit"

# Show commit history
./mgit log

# Create a branch from the current commit
./mgit branch feature

# Switch to a branch
./mgit checkout feature

# Detach HEAD at a specific commit
./mgit checkout <commit-hash>
```

## Repository Structure

Running `mgit init` creates the following structure:

```
.mgit/
  HEAD          # Points to the current branch (refs/heads/master)
  index         # Staging area
  objects/      # Object store
  refs/
    heads/
      master    # Master branch reference
```

## Requirements

- [Babashka](https://github.com/babashka/babashka)
