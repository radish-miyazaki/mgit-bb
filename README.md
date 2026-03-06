# mgit

A minimal Git implementation written in Clojure (Babashka) as a learning exercise to understand Git internals by building a simplified version from scratch.

## Reference

This implementation is based on the following Zenn book:

https://zenn.dev/ryu_9845343/books/fc32a59e1a3807

and references the Erlang (escript) implementation [radish-miyazaki/mgit-escript](https://github.com/radish-miyazaki/mgit-escript).

## Features

- `init` - Initialize a new mgit repository (creates `.mgit` directory with `objects`, `refs/heads`, `HEAD`, and `index`)

## Usage

```sh
# Make the script executable
chmod +x script.clj

# Initialize a repository
./script.clj init
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
