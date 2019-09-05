# For securely downloading/uploading files with remote server.
## For downloading files from remote server.
pscp -rp <user-name>@<remoteIP>:<absolute-path of file/files> <Local-path>
  
## To check list of files changed in linux recently
find . -type f -printf '%TY-%Tm-%Td %TT %p\n' | sort -r | head -10
