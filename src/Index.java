public class Index {

    class Document {
        int docID;
        LinkedList <Vocabulary> index;

        public Document() {
            docID = 0;
            index = new LinkedList <Vocabulary>();
        }

        public Document(int id, String []  words) {
            docID = id;
            index = new LinkedList <Vocabulary>();
            for ( int i = 0 ; i < words.length; i ++)
                index.insert(new Vocabulary (words[i]));

        }

        public void addNew (String word)
        {
            index.insert(new Vocabulary (word));
        }

        public boolean found(String word)
        {
            if (index.empty())
                return false;

            index.findFirst();
            for ( int i = 0 ; i < index.size ; i++)
            {
                if ( index.retrieve().word.compareTo(word) == 0)
                    return true;
                index.findNext();
            }
            return false;
        }
    }


    Document [] indexes;


    public Index() {
        indexes = new Document [100];
        for ( int i = 0 ; i < indexes.length ; i++)
        {
            indexes [i] = new Document();
            indexes [i].docID = i;
            indexes [i] = new Document();

        }
    }

    public void addALLDocument ( int docID, String [] data)
    {
        for ( int i = 0 ; i < data.length ; i++)
            indexes[docID].addNew(data[i]);
    }

    public void addDocument ( int docID, String data)
    {
        indexes[docID].addNew(data);
    }

    public void printDocment (int docID)
    {
        if ( indexes[docID].index.empty())
            System.out.println("Empty Document");
        else
        {
            indexes[docID].index.findFirst();
            for ( int i = 0; i< indexes[docID].index.size ; i++)
            {
                System.out.print (indexes[docID].index.retrieve() + " ");
                indexes[docID].index.findNext();
            }
        }
    }
}