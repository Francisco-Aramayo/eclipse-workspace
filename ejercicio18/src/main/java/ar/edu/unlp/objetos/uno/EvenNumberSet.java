package ar.edu.unlp.objetos.uno;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class EvenNumberSet implements Set<Integer> {

    private final Set<Integer> internalSet;

    public EvenNumberSet(){
        this.internalSet = new HashSet<>();
    }

    // =======================================================
    // MÉTODOS CON LÓGICA INYECTADA
    // =======================================================

    @Override
    public boolean add(Integer element) {
        // Lógica de restricción paridad y manejo de nulos
        if (element == null || element % 2 != 0) {
            return false;
        }
        // Delega la adición (HashSet maneja la unicidad)
        return this.internalSet.add(element);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        boolean changed = false;
        // Itera y utiliza el método add() con restricción de paridad
        for (Integer element : c) {
            if (this.add(element)) {
                changed = true;
            }
        }
        return changed;
    }

    // =======================================================
    // MÉTODOS DELEGADOS (Resto del Set)
    // =======================================================
    
    @Override // ¡Faltante!
    public int size() {
        return this.internalSet.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.internalSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.internalSet.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.internalSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.internalSet.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.internalSet.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return this.internalSet.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.internalSet.containsAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.internalSet.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.internalSet.removeAll(c);
    }

    @Override
    public void clear() {
        this.internalSet.clear();
    }
    
}