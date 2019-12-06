//
//  MemoriaDAO.swift
//  Memorias
//
//  Created by Valéria Cavalcanti on 06/12/19.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import Foundation
import CoreData
import UIKit

class MemoriaDAO: NSObject {
    var contexto: NSManagedObjectContext
    
    override init() {
        self.contexto = (UIApplication.shared.delegate as! AppDelegate).persistentContainer.viewContext
    }
    
    func add(assunto: String, gostou: Bool, comentarios: String, nota: Int, recomendacao: Int) -> Bool {
        let memoria = NSEntityDescription.insertNewObject(forEntityName: "Memoria", into: self.contexto)
        
        memoria.setValue(assunto, forKey: "assunto")
        memoria.setValue(gostou, forKey: "gostou")
        memoria.setValue(comentarios, forKey: "comentarios")
        memoria.setValue(nota, forKey: "nota")
        memoria.setValue(recomendacao, forKey: "recomendacao")
        
        do {
            try self.contexto.save()
            return true
        } catch {
            return false
        }
    }
    
    func get() -> Array<Memoria>? {
        var lista: [NSManagedObject] = []
        
        let requisicao = NSFetchRequest<NSFetchRequestResult>(entityName: "Memoria")
        do{
            try lista = self.contexto.fetch(requisicao) as! [NSManagedObject]
            //if (lista.count > 0){
                return lista as! Array<Memoria>
            //}
        }catch{
        }
        return nil
    }
}
