#!/usr/bin/env bb
(require '[babashka.fs :as fs])

(def mgit-dir-path (fs/path ".mgit"))
(def objects-dir-path (fs/path mgit-dir-path "objects"))
(def refs-dir-path (fs/path mgit-dir-path "refs"))
(def heads-dir-path (fs/path refs-dir-path "heads"))
(def head-file-path (fs/path mgit-dir-path "HEAD"))
(def index-file-path (fs/path mgit-dir-path "index"))

(defn- eprintln [& args]
  (binding [*out* *err*]
    (apply println args)))

(defmulti run-command identity)

(defmethod run-command :default
  [command]
  (eprintln (str "Unknown command: " command))
  (System/exit 1))

(defmethod  run-command "init" [_])

(defmethod run-command "init" [_]
  (if (fs/exists? mgit-dir-path)
    (println (str mgit-dir-path " already exists"))
    (do
      (doseq [path [mgit-dir-path objects-dir-path refs-dir-path heads-dir-path]]
        (fs/create-dirs path))
      (fs/write-lines head-file-path ["ref: refs/heads/master\n"])
      (fs/create-file index-file-path)
      (fs/create-file (fs/path heads-dir-path "master"))
      (println (str "Initialized empty mgit repository in " mgit-dir-path)))))

(defn -main []
  (when (empty? *command-line-args*)
    (eprintln "Usage: mgit <command> [<args>]")
    (System/exit 1))
  (let [command (first *command-line-args*)]
    (run-command command)))

(-main)
