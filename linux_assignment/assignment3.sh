for file in *.txt
do

if [ -f $file ];
then
newname=${file%%.*}_${file}
mv $file $newname
fi
done
