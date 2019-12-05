//
//  Cadastro.swift
//  Amigo Secreto
//
//  Created by Valéria Cavalcanti on 05/12/19.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import Foundation

class Cadastro: NSObject {
    var lista: Array<Confra>
    
    override init() {
        self.lista = Array<Confra>()
    }
    
    func add(confra: Confra) {
        self.lista.append(confra)
    }
    
    func get() -> Array<Confra> {
        return self.lista
    }
    
    func get(index: Int) -> Confra {
        return self.lista[index]
    }
    
    func del(index: Int) {
        self.lista.remove(at: index)
    }
    
    func count() -> Int {
        return self.lista.count
    }
}
