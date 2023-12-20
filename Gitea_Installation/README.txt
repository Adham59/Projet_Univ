Passage de MarkDown vers html:

Pour cela j'ai installer pandoc grace a la commande :
sudo apt-get install pandoc.

Ensuite j'ai fait la convertion grace a cette commande:
pandoc Rapport_final.md -t html -o Rapport_final.html -s --toc --css=css/index.css -N --metadata title="Rapport de SAE réseaux" --metadata author="Adham Berrakane, Nathan Dorny, Shega Berisa" --include-in-header=logo/logo.html


Passade de MarkDown vers pdf:

Taper cette commande dans le terminale : 
sudo apt-get install pandoc texlive-latex-base texlive-fonts-recommended texlive-extra-utils texlive-latex-extra

Ensuite pour la convertion vers pdf taper cette commande : 
pandoc Rapport_final.md --pdf-engine=xelatex -o Rapport_final.pdf -s --toc -N  --metadata title="Rapport de SAE réseaux" --metadata author="Adham Berrakane, Nathan Dorny, Shega Berisa"


