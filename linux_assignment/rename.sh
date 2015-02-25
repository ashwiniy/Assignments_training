for file in *[a][0-9a-z].*
do
  mv "$file.*" "${file_a*}.*"
done
