package fr.univlille.info.G3.utils;

public interface Observer {
    
        public void update(Subject subj);
        public void update(Subject subj, Object data);
}
