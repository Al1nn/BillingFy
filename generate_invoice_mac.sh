cd script
if [[ $(command -v brew) == "" ]]; then
    echo "Installing Hombrew"
    /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
else
    echo "Homebrew version"
    brew --version
fi
pythonv="$(python3 -V 2>&1)"
if [[ -z "$pythonv" ]]
then
    brew install python3
else
    echo "$pythonv"
fi
pipv="$(pip3 -V 2>&1)"
if [[ -z "$pipv" ]]
then
    brew install pip3
else
    echo "$pipv"
fi
python3 main.py
