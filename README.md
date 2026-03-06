# mgit

A minimal Git implementation written in Clojure (Babashka) as a learning exercise to understand Git's internal workings.

This project is inspired by the Zenn article: [Gitをつくってみる](https://zenn.dev/ryu_9845343/books/fc32a59e1a3807), and references the Erlang (escript) implementation [radish-miyazaki/mgit-escript](https://github.com/radish-miyazaki/mgit-escript).

## Requirements

- [Babashka](https://github.com/babashka/babashka)

## Usage

```sh
./script.clj <command> [<args>]
```

## Implemented Commands

### `init`

Initializes a new mgit repository in the current directory.

```sh
./script.clj init
```

This creates a `.mgit` directory with the following structure:

```
.mgit/
├── HEAD          # Points to the current branch (refs/heads/master)
├── index         # Staging area
├── objects/      # Object storage
└── refs/
    └── heads/
        └── master
```
